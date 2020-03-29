package tw.fondus.commons.cli.exec;

import org.junit.Assert;
import org.junit.Test;
import org.zeroturnaround.exec.InvalidExitValueException;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/**
 * The unit test of executions.
 * 
 * @author Brad Chen
 *
 */
public class ExecutionsTest {
	
	@Test
	public void test() throws InvalidExitValueException, IOException, InterruptedException, TimeoutException {
		 Executions.execute( Executions.SETTING_NOTHING,
					"java", "-version" );
	}
	
	@Test
	public void testOutput() throws InvalidExitValueException, IOException, InterruptedException, TimeoutException {
		String output = Executions.execute( executor -> executor.readOutput( true ),
				"java", "-version" ).outputUTF8();
		
		Assert.assertTrue( Objects.nonNull( output ) );
	}
}
