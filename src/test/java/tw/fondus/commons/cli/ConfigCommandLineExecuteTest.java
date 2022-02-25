package tw.fondus.commons.cli;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tw.fondus.commons.cli.argument.ConfigArguments;

import java.nio.file.Path;

/**
 * The unit test of ConfigCommandLineExecute.
 * 
 * @author Brad Chen
 *
 */
public class ConfigCommandLineExecuteTest {
	private static String[] args;
	
	@BeforeAll
	public static void setUp() {
		args = new String[]{
				"-b",
				"src/test/resources",
				"-c",
				"test.properties"
				};
	}
	
	@Test
	public void test() {
		ConfigArguments arguments = ConfigArguments.instance();
		new TestCLI().execute( args, arguments );
	}
	
	/**
	 * Test implements with ConfigCommandLineExecute.
	 * 
	 * @author Brad Chen
	 *
	 */
	private static class TestCLI extends ConfigCommandLineExecute {
		@Override
		protected void configRun( ConfigArguments arguments, Path basePath, Path inputPath, Path outputPath,
				Path configPath ) {
			Assertions.assertEquals( "test.properties", arguments.getConfig() );
			Assertions.assertEquals( configPath, basePath.resolve( arguments.getConfig() ) );
		}
	}
}
