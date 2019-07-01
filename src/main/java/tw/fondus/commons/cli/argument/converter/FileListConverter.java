package tw.fondus.commons.cli.argument.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.beust.jcommander.IStringConverter;

/**
 * Convert arguments string file list with comma symbol.
 * 
 * @author Brad Chen
 *
 */
public class FileListConverter implements IStringConverter<List<String>> {
	@Override
	public List<String> convert( String files ) {
		String[] paths = files.split( "," );
		return Stream.of( paths ).collect( Collectors.toList() );
	}
}
