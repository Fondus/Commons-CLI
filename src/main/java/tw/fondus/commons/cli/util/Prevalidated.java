package tw.fondus.commons.cli.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

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
	 * @param path string of path
	 * @param message error message
	 * @return path
	 */
	public static Path checkExists( String path, String message ) {
		return checkExists( Paths.get( path ), message );
	}

	/**
	 * Check the path exists, if not will throw exception with message.
	 * 
	 * @param path path
	 * @param message error message
	 * @return path
	 */
	public static Path checkExists( Path path, String message ) {
		Objects.requireNonNull( message );
		if ( !Files.exists( Objects.requireNonNull( path ) ) ) {
			log.error( message );
			throw new IllegalStateException( message );
		} else {
			return path;
		}
	}

	/**
	 * Check the element index in an array.
	 * 
	 * @param index index
	 * @param size size
	 * @return index
	 */
	@Deprecated
	public static int checkElementIndex( int index, int size ) {
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException( "The index: " + index + " out of bounds: " + size + "." );
		}
		return index;
	}

	/**
	 * Check the object should non null, , if null will throw exception with message.
	 * 
	 * @param instance instance
	 * @param message error message
	 * @return instance
	 */
	@Deprecated
	public static <T> T checkNonNull( T instance, String message ) {
		return Objects.requireNonNull( instance, message );
	}
}
