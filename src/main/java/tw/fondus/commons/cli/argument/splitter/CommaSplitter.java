package tw.fondus.commons.cli.argument.splitter;

import com.beust.jcommander.converters.IParameterSplitter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The splitter to split comma symbol with arguments.
 *
 * @author Brad Chen
 * @since 0.4.0
 */
public class CommaSplitter implements IParameterSplitter {
	@Override
	public List<String> split( String s ) {
		return Stream.of( s.split( "," ) ).collect( Collectors.toList() );
	}
}
