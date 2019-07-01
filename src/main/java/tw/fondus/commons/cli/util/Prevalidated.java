package tw.fondus.commons.cli.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 * The Utilities use for command-line interface validated.
 * 
 * @author Brad Chen
 *
 */
@Slf4j
public class Prevalidated {
	
	private Prevalidated() {}
	
	/**
	 * Check the path exists, if not will throw exception.
	 * 
	 * @param path
	 * @param errorMessage
	 */
	public static void checkExists( Path path, String errorMessage ) {
		Objects.requireNonNull( errorMessage );
		if ( !Files.exists( path ) ) {
			log.error( errorMessage );
			throw new IllegalStateException( errorMessage );
		}
	}
}
