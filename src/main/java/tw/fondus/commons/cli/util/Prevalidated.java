package tw.fondus.commons.cli.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import strman.Strman;

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
	 * Check the path exists, if not will throw exception with message.
	 * 
	 * @param path
	 * @param message
	 */
	public static void checkExists( Path path, String message ) {
		Objects.requireNonNull( message );
		if ( !Files.exists( path ) ) {
			log.error( message );
			throw new IllegalStateException( message );
		}
	}
	
	/**
	 * Check the element index in an array.
	 * 
	 * @param index
	 * @param size
	 * @return
	 */
	public static int checkElementIndex( int index, int size ) {
	    if (index < 0 || index >= size) {
	      throw new IndexOutOfBoundsException( Strman.append( "The index: ", String.valueOf( index ), " out of bounds: ", String.valueOf( size ), "." ) );
	    }
	    return index;
	  }
	
	/**
	 * Check the object should non null, , if null will throw exception with message.
	 * 
	 * @param instance
	 * @param message
	 * @return
	 */
	public static <T> T checkNonNull( T instance, String message ) {
		return Objects.requireNonNull( instance, message );
	}
}
