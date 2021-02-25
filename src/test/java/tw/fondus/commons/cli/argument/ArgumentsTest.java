package tw.fondus.commons.cli.argument;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
		Assertions.assertFalse( arguments.isHelp() );
	}

	@Test
	public void testBasic(){
		BasicArguments arguments = BasicArguments.builder()
				.help( true )
				.basePath( Paths.get( "src/test/resources" ) )
				.build();
		Assertions.assertTrue( arguments.isHelp() );
		Assertions.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		Assertions.assertEquals( "Input/", arguments.getInputPath() );
		Assertions.assertEquals( "Output/", arguments.getOutputPath() );
	}

	@Test
	public void testBasicIOFiles(){
		BasicIOFilesArguments arguments = BasicIOFilesArguments.builder()
				.help( true )
				.basePath( Paths.get( "src/test/resources" ) )
				.inputs( Arrays.asList( "Input1.txt", "Input2.txt" ) )
				.outputs( Arrays.asList( "Output1.txt", "Output2.txt" ) )
				.build();

		Assertions.assertTrue( arguments.isHelp() );
		Assertions.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		Assertions.assertEquals( "Input/", arguments.getInputPath() );
		Assertions.assertEquals( "Output/", arguments.getOutputPath() );
		Assertions.assertEquals( "Input1.txt", arguments.getInputs().get( 0 ) );
		Assertions.assertEquals( "Input2.txt", arguments.getInputs().get( 1 ) );
		Assertions.assertEquals( "Output1.txt", arguments.getOutputs().get( 0 ) );
		Assertions.assertEquals( "Output2.txt", arguments.getOutputs().get( 1 ) );
	}

	@Test
	public void testConfig(){
		ConfigArguments arguments = ConfigArguments.builder()
				.basePath( Paths.get( "src/test/resources" ) )
				.config( "Config/" )
				.build();

		Assertions.assertFalse( arguments.isHelp() );
		Assertions.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		Assertions.assertEquals( "Input/", arguments.getInputPath() );
		Assertions.assertEquals( "Output/", arguments.getOutputPath() );
		Assertions.assertEquals( "Config/", arguments.getConfig() );
	}
}
