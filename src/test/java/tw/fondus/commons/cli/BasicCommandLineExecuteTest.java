package tw.fondus.commons.cli;

import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.Getter;
import tw.fondus.commons.cli.argument.BasicArguments;

/**
 * The unit test of BasicCommandLineExecute.
 * 
 * @author Brad Chen
 *
 */
public class BasicCommandLineExecuteTest {
	@Getter
	private String[] args;
	
	@Before
	public void setUp() {
		this.args = new String[]{
				"-b",
				"src/test/resources"
				};
	}
	
	@Test
	public void test() {
		BasicArguments arguments = new BasicArguments();
		new TestCLI().execute( this.getArgs(), arguments );
	}
	
	/**
	 * Test implements with BasicCommandLineExecute.
	 * 
	 * @author Brad Chen
	 *
	 */
	private class TestCLI extends BasicCommandLineExecute {
		@Override
		protected void run( BasicArguments arguments, Path basePath, Path inputPath, Path outputPath )
				throws Exception {
			Assert.assertTrue( arguments.getBasePath().equals( "src/test/resources" ) );
		}
	}
}
