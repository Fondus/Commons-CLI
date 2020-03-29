package tw.fondus.commons.cli;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.fondus.commons.cli.argument.BasicArguments;

import java.nio.file.Path;
import java.nio.file.Paths;

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
		BasicArguments arguments = BasicArguments.builder().build();
		new TestCLI().execute( this.getArgs(), arguments );
	}
	
	/**
	 * Test implements with BasicCommandLineExecute.
	 * 
	 * @author Brad Chen
	 *
	 */
	private static class TestCLI extends BasicCommandLineExecute {
		@Override
		protected void run( BasicArguments arguments, Path basePath, Path inputPath, Path outputPath ) {
			Assert.assertFalse( arguments.isHelp() );
			Assert.assertEquals( Paths.get( "src/test/resources" ), arguments.getBasePath() );
			Assert.assertEquals( "Input/", arguments.getInputPath() );
			Assert.assertEquals( "Output/", arguments.getOutputPath() );
			Assert.assertEquals( Paths.get( "src/test/resources/Input" ), inputPath );
			Assert.assertEquals( Paths.get( "src/test/resources/Output" ), outputPath );
		}
	}
}
