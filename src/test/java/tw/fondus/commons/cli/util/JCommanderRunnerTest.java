package tw.fondus.commons.cli.util;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.fondus.commons.cli.argument.BasicArguments;

import java.nio.file.Paths;

/**
 * The unit test of  JCommanderRunner.
 *
 * @author Brad Chen
 *
 */
public class JCommanderRunnerTest {
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
	public void test(){
		JCommanderRunner.execute( this.getArgs(), BasicArguments.builder().build(), "UnitTest", arguments -> {
			Assert.assertFalse( arguments.isHelp() );
			Assert.assertEquals( Paths.get( "src/test/resources" ) , arguments.getBasePath() );
		} );
	}
}
