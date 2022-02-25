package tw.fondus.commons.cli.argument.splitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The unit test of CommaSplitter.
 *
 * @author Brad Chen
 *
 */
public class CommaSplitterTest {
	@Test
	public void test(){
		List<String> list = new CommaSplitter().split( "1,2,3,4,5" );
		Assertions.assertEquals( 5, list.size() );
		Assertions.assertEquals( "1", list.get( 0 ) );
		Assertions.assertEquals( "2", list.get( 1 ) );
		Assertions.assertEquals( "3", list.get( 2 ) );
	}
}
