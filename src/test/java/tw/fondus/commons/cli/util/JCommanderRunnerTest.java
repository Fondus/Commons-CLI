package tw.fondus.commons.cli.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tw.fondus.commons.cli.argument.BasicArguments;

import java.nio.file.Paths;

/**
 * The unit test of  JCommanderRunner.
 *
 * @author Brad Chen
 *
 */
public class JCommanderRunnerTest {
	private static String[] args;

	@BeforeAll
	public static void setUp() {
		args = new String[]{
				"-b",
				"src/test/resources"
		};
	}

	@Test
	public void test(){
		JCommanderRunner.execute( args, BasicArguments.builder().build(), "UnitTest", arguments -> {
			Assertions.assertFalse( arguments.isHelp() );
			Assertions.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		} );
	}
}
