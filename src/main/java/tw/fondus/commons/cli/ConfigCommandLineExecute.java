package tw.fondus.commons.cli;

import java.nio.file.Path;
import java.nio.file.Paths;

import strman.Strman;
import tw.fondus.commons.cli.argument.BasicArguments;
import tw.fondus.commons.cli.argument.ConfigArguments;
import tw.fondus.commons.cli.util.Prevalidated;

/**
 * A Parent class interface use to execute program with configuration command-line interface.
 * 
 * @author Brad Chen
 * @see BasicCommandLineExecute
 */
public abstract class ConfigCommandLineExecute extends BasicCommandLineExecute {
	private Path configPath;
	
	@Override
	protected void run( BasicArguments arguments, Path basePath, Path inputPath, Path outputPath ) throws Exception {
		ConfigArguments configArguments = (ConfigArguments) arguments;
		
		// Check the configuration file path.
		this.configPath = Paths.get( Strman.append( basePath.toString(), PATH, configArguments.getConfig() ) );
		Prevalidated.checkExists( this.configPath, "Config CommandLineExecute: The configuration file not exist." );
		
		this.configRun( configArguments, basePath, inputPath, outputPath, configPath );
	}
	
	/**
	 * Execute process with arguments and configuration file.
	 * 
	 * @param arguments
	 * @param basePath
	 * @param inputPath
	 * @param outputPath
	 * @param configPath
	 */
	protected abstract void configRun( ConfigArguments arguments, Path basePath, Path inputPath, Path outputPath, Path configPath );
}
