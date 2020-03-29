package tw.fondus.commons.cli.argument.converter;

import com.beust.jcommander.IStringConverter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Convert arguments string file list with comma symbol.
 * 
 * @author Brad Chen
 *
 */
@Deprecated
public class FileListConverter implements IStringConverter<List<String>> {
	@Override
	public List<String> convert( String files ) {
		String[] paths = files.split( "," );
		return Stream.of( paths ).collect( Collectors.toList() );
	}
}
