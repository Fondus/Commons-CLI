package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Standard arguments of Command-Line Interface base on BasicArguments.<br/>
 * This arguments used to specified the configuration file, with more complex setting with program. <br/>
 * The format such like properties, XML and everything you want.
 * 
 * @author Brad Chen
 * @see BasicArguments
 */
@Data
@SuperBuilder
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class ConfigArguments extends BasicArguments {
	@Parameter( names = { "--config", "-c" }, required = true,
			description = "The file name of configuration, relative to the current working directory.")
	private String config;

	/**
	 * Create the argument instance.
	 *
	 * @return argument instance
	 * @since 0.4.2
	 */
	public static ConfigArguments instance(){
		return ConfigArguments.builder().build();
	}
}
