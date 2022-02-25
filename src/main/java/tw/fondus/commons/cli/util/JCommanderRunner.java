package tw.fondus.commons.cli.util;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import lombok.extern.slf4j.Slf4j;
import tw.fondus.commons.cli.argument.IHelpArgument;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * The runner of parse command-line arguments base on JCommander.
 *
 * @author Brad Chen
 * @since 0.3.0
 */
@Slf4j
public class JCommanderRunner {
	private JCommanderRunner(){}

	/**
	 * Running the jcommander parse arguments, after finished then execute the main process with arguments.
	 *
	 * @param args string of cli arguments
	 * @param arguments the cli arguments instance
	 * @param programName program name
	 * @param mainProcess the cli main process
	 * @param <T> type of cli arguments
	 */
	public static <T extends IHelpArgument> void execute( String[] args, T arguments, String programName, Consumer<T> mainProcess ) {
		JCommander command = JCommander.newBuilder()
				.programName( Objects.requireNonNull( programName, "JCommanderRunner: The program name can't not be null." ) )
				.addObject( Objects.requireNonNull( arguments, "JCommanderRunner: The arguments can't not be null." ) )
				.acceptUnknownOptions( true )
				.build();
		try {
			// Parse the string arguments
			command.parse( args );

			if ( arguments.isHelp() ) {
				command.usage();
			} else {
				log.info( "JCommanderRunner: Running the main process after parse arguments." );
				Objects.requireNonNull( mainProcess ).accept( arguments );
			}

		} catch ( ParameterException e ) {
			log.error( "JCommanderRunner: The arguments parse has exception.", e );
			command.usage();
		}
	}
}
