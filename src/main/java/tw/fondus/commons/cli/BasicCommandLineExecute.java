package tw.fondus.commons.cli;

import lombok.extern.slf4j.Slf4j;
import tw.fondus.commons.cli.argument.BasicArguments;
import tw.fondus.commons.cli.util.JCommanderRunner;
import tw.fondus.commons.cli.util.Prevalidated;

import java.nio.file.Path;

/**
 * A Parent class interface use to execute program with basic command-line interface.
 * 
 * @author Brad Chen
 *
 */
@Slf4j
public abstract class BasicCommandLineExecute {
	@Deprecated
	protected static final String PATH = System.getProperty( "file.separator" );

	/**
	 * Use BasicArguments to execute program with command-line interface.<br/>
	 * Will check basic arguments.
	 * 
	 * @param args the command line arguments.
	 * @param arguments the program arguments.
	 */
	public void execute( String[] args, BasicArguments arguments ) {
		JCommanderRunner.execute( args, arguments, this.getClass().getSimpleName(), basicArguments -> {
			Path inputPath = Prevalidated.checkExists( basicArguments.getBasePath().resolve( basicArguments.getInputPath() ),
					"CommandLineExecute: The input directory not exist." );

			Path outputPath = Prevalidated.checkExists( basicArguments.getBasePath().resolve( basicArguments.getOutputPath() ),
					"CommandLineExecute: The output directory not exist." );

			// Run the main process
			this.run( basicArguments, basicArguments.getBasePath(), inputPath, outputPath );
		} );
	}

	/**
	 * Execute process with arguments and working directory.
	 * 
	 * @param arguments the program arguments.
	 * @param basePath the current working directory.
	 * @param inputPath the input directory path, relative to the current working directory.
	 * @param outputPath the output directory path, relative to the current working directory.
	 */
	protected abstract void run( BasicArguments arguments, Path basePath, Path inputPath, Path outputPath );
}
