package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import tw.fondus.commons.cli.argument.converter.ToPathConverter;

import java.nio.file.Path;

/**
 * Basic arguments of command-line interface, it's not included input and output files.<br/>
 * If you want expand arguments, use extends to expand arguments please.
 * 
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class BasicArguments extends BasicHelpArguments {
	@Parameter( names = { "--base", "-b" }, required = true, description = "The current working directory.", converter = ToPathConverter.class )
	private Path basePath;

	@Builder.Default
	@Parameter( names = { "--idir", "-id" }, description = "The input file folder, relative to the current working directory." )
	private String inputPath = "Input/";

	@Builder.Default
	@Parameter( names = { "--odir", "-od" }, description = "The output file folder, relative to the current working directory." )
	private String outputPath = "Output/";

	/**
	 * Create the argument instance.
	 *
	 * @return argument instance
	 * @since 0.4.2
	 */
	public static BasicArguments instance(){
		return BasicArguments.builder().build();
	}
}
