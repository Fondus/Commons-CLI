package tw.fondus.commons.cli;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.fondus.commons.cli.argument.ConfigArguments;

import java.nio.file.Path;

/**
 * The unit test of ConfigCommandLineExecute.
 * 
 * @author Brad Chen
 *
 */
public class ConfigCommandLineExecuteTest {
	@Getter
	private String[] args;
	
	@Before
	public void setUp() {
		this.args = new String[]{
				"-b",
				"src/test/resources",
				"-c",
				"test.properties"
				};
	}
	
	@Test
	public void test() {
		ConfigArguments arguments = ConfigArguments.builder().build();
		new TestCLI().execute( this.getArgs(), arguments );
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
			Assert.assertEquals( "test.properties", arguments.getConfig() );
			Assert.assertEquals( configPath, basePath.resolve( arguments.getConfig() ) );
		}
	}
}
