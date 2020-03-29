package tw.fondus.commons.cli.argument.splitter;

import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertEquals( 5, list.size() );
		Assert.assertEquals( "1", list.get( 0 ) );
		Assert.assertEquals( "2", list.get( 1 ) );
		Assert.assertEquals( "3", list.get( 2 ) );
	}
}
