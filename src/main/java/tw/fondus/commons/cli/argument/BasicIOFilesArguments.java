package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import tw.fondus.commons.cli.argument.splitter.CommaSplitter;

import java.util.List;

/**
 * Basic arguments of command-line interface, it's included input and output files.<br/>
 * If you want expand arguments, use extends to expand arguments please.
 * 
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class BasicIOFilesArguments extends BasicArguments {
	@Parameter( names = { "--input", "-i" }, required = true, description = "The input file list with comma, and order is fixed.",
			splitter = CommaSplitter.class )
	private List<String> inputs;

	@Parameter( names = { "--output", "-o" }, required = true, description = "The output file list with comma, and order is fixed.",
			splitter = CommaSplitter.class )
	private List<String> outputs;
}
