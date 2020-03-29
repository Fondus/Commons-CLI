package tw.fondus.commons.cli.argument.converter;

import com.beust.jcommander.IStringConverter;
import tw.fondus.commons.cli.util.Prevalidated;

import java.nio.file.Path;

/**
 * The converter to convert the string argument into path.
 *
 * @author Brad Chen
 * @since 0.4.0
 */
public class ToPathConverter implements IStringConverter<Path> {
	@Override
	public Path convert( String s ) {
		return Prevalidated.checkExists( s, "ToPathConverter: Can not find" + s + " exist." );
	}
}
