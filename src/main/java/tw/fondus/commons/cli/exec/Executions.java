package tw.fondus.commons.cli.exec;

import org.zeroturnaround.exec.InvalidExitValueException;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.ProcessResult;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

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
	 * @param commands commands
	 * @return executor
	 */
	public static ProcessExecutor buildExecutor( String... commands ) {
		return new ProcessExecutor()
				.command( commands );
	}
	
	/**
	 * Execution with commands after custom executor setting. <br/>
	 * Example: executor -> { executor to setting };
	 * 
	 * @param executorSetting executor setting process
	 * @param commands commands
	 * @throws InvalidExitValueException invalid exitValue exception
	 * @throws IOException io exception
	 * @throws InterruptedException interrupted exception
	 * @throws TimeoutException time out exception
	 * @return process result
	 */
	public static ProcessResult execute( Function<ProcessExecutor, ProcessExecutor> executorSetting, String... commands ) throws InvalidExitValueException, IOException, InterruptedException, TimeoutException {
		Objects.requireNonNull( executorSetting, "Executions: executorSetting" );
		Objects.requireNonNull( commands, "Executions: commands" );
		return executorSetting
			.apply( buildExecutor( commands ) )
			.execute();
	}
}
