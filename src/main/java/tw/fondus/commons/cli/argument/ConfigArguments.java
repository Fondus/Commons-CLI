package tw.fondus.commons.cli.argument;

import com.beust.jcommander.Parameter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Standard arguments of Command-Line Interface base on BasicArguments.<br/>
 * This arguments used to specified the configuration file, with more complex setting with program. <br/>
 * The format such like properties, XML and everything you want.
 * 
 * @author Brad Chen
 * @see BasicArguments
 */
@Data
@EqualsAndHashCode( callSuper=false )
public class ConfigArguments extends BasicArguments {
	@Parameter( names = { "--config", "-c" }, required = true,
			description = "The file name of configuration, relative to the current working directory.")
	private String config;
}
