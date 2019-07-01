package tw.fondus.commons.cli;

import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.Getter;
import strman.Strman;
import tw.fondus.commons.cli.argument.ConfigArguments;

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
		ConfigArguments arguments = new ConfigArguments();
		new TestCLI().execute( this.getArgs(), arguments );
	}
	
	/**
	 * Test implements with ConfigCommandLineExecute.
	 * 
	 * @author Brad Chen
	 *
	 */
	private class TestCLI extends ConfigCommandLineExecute {
		@Override
		protected void configRun( ConfigArguments arguments, Path basePath, Path inputPath, Path outputPath,
				Path configPath ) {
			Assert.assertTrue( arguments.getConfig().equals( "test.properties" ) );
			Assert.assertTrue( Strman.append( basePath.toString(), PATH, arguments.getConfig() ).equals( configPath.toString() ) );
		}
	}
}
