package tw.fondus.commons.cli;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
	private static String[] args;
	
	@BeforeAll
	public static void setUp() {
		args = new String[]{
				"-b",
				"src/test/resources"
				};
	}
	
	@Test
	public void test() {
		BasicArguments arguments = BasicArguments.instance();
		new TestCLI().execute( args, arguments );
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
			Assertions.assertFalse( arguments.isHelp() );
			Assertions.assertEquals( Paths.get( "src/test/resources" ), arguments.getBasePath() );
			Assertions.assertEquals( "Input/", arguments.getInputPath() );
			Assertions.assertEquals( "Output/", arguments.getOutputPath() );
			Assertions.assertEquals( Paths.get( "src/test/resources/Input" ), inputPath );
			Assertions.assertEquals( Paths.get( "src/test/resources/Output" ), outputPath );
		}
	}
}
