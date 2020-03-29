package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * Basic arguments of command-line interface with help option.<br/>
 * If you want expand arguments, use extends to expand arguments please.
 * 
 * @author Brad Chen
 * @since 0.4.0
 */
@Data
@SuperBuilder
public class BasicHelpArguments implements IHelpArgument {
	@Builder.Default
	@Parameter( names = { "--help", "-h" }, description = "Show how to usage.", help = true )
	private boolean help = false;
}
