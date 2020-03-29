package tw.fondus.commons.cli.argument;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * The unit test of arguments.
 *
 * @author Brad Chen
 *
 */
public class ArgumentsTest {
	@Test
	public void testBasicHelp(){
		BasicHelpArguments arguments = BasicHelpArguments.builder().build();
		Assert.assertFalse( arguments.isHelp() );
	}

	@Test
	public void testBasic(){
		BasicArguments arguments = BasicArguments.builder()
				.help( true )
				.basePath( Paths.get( "src/test/resources" ) )
				.build();
		Assert.assertTrue( arguments.isHelp() );
		Assert.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		Assert.assertEquals( "Input/", arguments.getInputPath() );
		Assert.assertEquals( "Output/", arguments.getOutputPath() );
	}

	@Test
	public void testConfig(){
		ConfigArguments arguments = ConfigArguments.builder()
				.basePath( Paths.get( "src/test/resources" ) )
				.config( "Config/" )
				.build();

		Assert.assertFalse( arguments.isHelp() );
		Assert.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		Assert.assertEquals( "Input/", arguments.getInputPath() );
		Assert.assertEquals( "Output/", arguments.getOutputPath() );
		Assert.assertEquals( "Config/", arguments.getConfig() );
	}
}
