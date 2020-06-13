package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import tw.fondus.commons.cli.argument.converter.ToPathConverter;

import java.nio.file.Path;

/**
 * Basic arguments of command-line interface, it's not included input and output folders.<br/>
 * If you want expand arguments, use extends to expand arguments please.
 * 
 * @author Brad Chen
 * @since 0.4.0
 */
@Data
@SuperBuilder
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class BasicNoIOArguments extends BasicHelpArguments {
	@Parameter( names = { "--base", "-b" }, required = true, description = "The current working directory.", converter = ToPathConverter.class )
	private Path basePath;

	/**
	 * Create the argument instance.
	 *
	 * @return argument instance
	 * @since 0.4.2
	 */
	public static BasicNoIOArguments instance(){
		return BasicNoIOArguments.builder().build();
	}
}
