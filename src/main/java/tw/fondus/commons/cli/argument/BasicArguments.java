package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;

import lombok.Data;

/**
 * Basic arguments of Command-Line Interface.<br/>
 * Not included input and output files.<br/>
 * If you want expand arguments, use extends to expand arguments please.
 * 
 * @author Brad Chen
 *
 */
@Data
public class BasicArguments {
	@Parameter( names = { "--help", "-h" }, description = "Show how to usage.", help = true )
	private boolean help = false;

	@Parameter( names = { "--base", "-b" }, required = true, description = "The current working directory." )
	private String basePath;

	@Parameter( names = { "--idir", "-id" }, description = "The input file folder, relative to the current working directory." )
	private String inputPath = "Input/";

	@Parameter( names = { "--odir", "-od" }, description = "The output file folder, relative to the current working directory." )
	private String outputPath = "Output/";
}
