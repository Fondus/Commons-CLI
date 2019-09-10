package tw.fondus.commons.cli;

import java.nio.file.Path;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import lombok.extern.slf4j.Slf4j;
import strman.Strman;
import tw.fondus.commons.cli.argument.BasicArguments;
import tw.fondus.commons.cli.util.Prevalidated;

/**
 * A Parent class interface use to execute program with basic command-line interface.
 * 
 * @author Brad Chen
 *
 */
@Slf4j
public abstract class BasicCommandLineExecute {
	protected static final String PATH = System.getProperty( "file.separator" );
	private Path basePath;
	private Path inputPath;
	private Path outputPath;

	/**
	 * Use BasicArguments to execute program with command-line interface.<br/>
	 * Will check basic arguments.
	 * 
	 * @param args
	 * @param arguments
	 * @throws Exception
	 */
	public void execute( String[] args, BasicArguments arguments ) {
		JCommander command = JCommander.newBuilder().addObject( arguments ).build();
		command.setProgramName( this.getClass().getSimpleName() );

		try {
			// Parse the string arguments
			command.parse( args );

			if ( arguments.isHelp() ) {
				command.usage();
			} else {
				this.basePath = Prevalidated.checkExists( 
						arguments.getBasePath(),
						"CommandLineExecute: Can not find working directory exist." );

				this.inputPath = Prevalidated.checkExists( 
						Strman.append( arguments.getBasePath(), PATH, arguments.getInputPath() )
						, "CommandLineExecute: The input directory not exist." );
				
				this.outputPath = Prevalidated.checkExists( 
						Strman.append( arguments.getBasePath(), PATH, arguments.getOutputPath() ),
						"CommandLineExecute: The output directory not existt." );
				
				// Run the main process
				this.run( arguments, basePath, inputPath, outputPath );
			}

		} catch (ParameterException e) {
			log.error( "CommandLineExecute: The arguments parse exception.", e );
			command.usage();
		} catch (Exception e) {
			log.error( "CommandLineExecute: The main process has something wrong.", e );
		}
	}

	/**
	 * Execute process with arguments and working directory.
	 * 
	 * @param arguments
	 *            :The program arguments.
	 * @param basePath
	 *            :The current working directory.
	 * @param inputPath
	 *            :The input directory path, relative to the current working directory.
	 * @param outputPath
	 *            :The output directory path, relative to the current working directory.
	 * @throws Exception
	 */
	protected abstract void run( BasicArguments arguments, Path basePath, Path inputPath, Path outputPath )
			throws Exception;
}
