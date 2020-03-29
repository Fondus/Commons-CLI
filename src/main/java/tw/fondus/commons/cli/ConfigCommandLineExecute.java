package tw.fondus.commons.cli;

import tw.fondus.commons.cli.argument.BasicArguments;
import tw.fondus.commons.cli.argument.ConfigArguments;
import tw.fondus.commons.cli.util.Prevalidated;

import java.nio.file.Path;

/**
 * A Parent class interface use to execute program with configuration command-line interface.
 * 
 * @author Brad Chen
 * @see BasicCommandLineExecute
 */
public abstract class ConfigCommandLineExecute extends BasicCommandLineExecute {

	@Override
	protected void run( BasicArguments arguments, Path basePath, Path inputPath, Path outputPath ) {
		ConfigArguments configArguments = (ConfigArguments) arguments;
		
		// Check the configuration file path.
		Path configPath = Prevalidated.checkExists( basePath.resolve( configArguments.getConfig() ),
				"Config CommandLineExecute: The configuration file not exist." );
		
		this.configRun( configArguments, basePath, inputPath, outputPath, configPath );
	}
	
	/**
	 * Execute process with arguments and configuration file.
	 * 
	 * @param arguments the program arguments
	 * @param basePath the current working directory
	 * @param inputPath the input directory path, relative to the current working directory
	 * @param outputPath the output directory path, relative to the current working directory
	 * @param configPath the config directory path, relative to the current working directory
	 */
	protected abstract void configRun( ConfigArguments arguments, Path basePath, Path inputPath, Path outputPath, Path configPath );
}
