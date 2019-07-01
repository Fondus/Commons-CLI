package tw.fondus.commons.cli.exec;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.zeroturnaround.exec.InvalidExitValueException;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.ProcessResult;

/**
 * The Utilities to simple use {@link org.zeroturnaround.exec.ProcessExecutor}.
 * 
 * @author Brad Chen
 * @see org.zeroturnaround.exec.ProcessExecutor
 */
public class Executions {
	/**
	 * Not setting executor. 
	 */
	public static final Function<ProcessExecutor, ProcessExecutor> SETTING_NOTHING = executor -> executor;
	
	private Executions() {}
	
	/**
	 * Build the executor with commands.
	 * 
	 * @param commands
	 * @return
	 */
	public static ProcessExecutor buildExecutor( String... commands ) {
		return new ProcessExecutor()
				.command( commands );
	}
	
	/**
	 * Execution with commands after custom executor setting. <br/>
	 * Example: executor -> { executor to setting };
	 * 
	 * @param executorSetting
	 * @param commands
	 * @throws InvalidExitValueException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @return
	 */
	public static ProcessResult execute( Function<ProcessExecutor, ProcessExecutor> executorSetting, String... commands ) throws InvalidExitValueException, IOException, InterruptedException, TimeoutException {
		Objects.requireNonNull( executorSetting, "Executions: executorSetting" );
		Objects.requireNonNull( commands, "Executions: commands" );
		return executorSetting
			.apply( buildExecutor( commands ) )
			.execute();
	}
}
