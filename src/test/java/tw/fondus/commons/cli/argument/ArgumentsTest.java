package tw.fondus.commons.cli.argument;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;

/**
 * The unit test of arguments.
 *
 * @author Brad Chen
 *
 */
public class ArgumentsTest {
	@Test
	public void testBasicHelp(){
		BasicHelpArguments arguments = BasicHelpArguments.instance();
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
	public void testBasicIOFiles(){
		BasicIOFilesArguments arguments = BasicIOFilesArguments.builder()
				.help( true )
				.basePath( Paths.get( "src/test/resources" ) )
				.inputs( Arrays.asList( "Input1.txt", "Input2.txt" ) )
				.outputs( Arrays.asList( "Output1.txt", "Output2.txt" ) )
				.build();

		Assert.assertTrue( arguments.isHelp() );
		Assert.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		Assert.assertEquals( "Input/", arguments.getInputPath() );
		Assert.assertEquals( "Output/", arguments.getOutputPath() );
		Assert.assertEquals( "Input1.txt", arguments.getInputs().get( 0 ) );
		Assert.assertEquals( "Input2.txt", arguments.getInputs().get( 1 ) );
		Assert.assertEquals( "Output1.txt", arguments.getOutputs().get( 0 ) );
		Assert.assertEquals( "Output2.txt", arguments.getOutputs().get( 1 ) );
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
