package tw.fondus.commons.cli.argument.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

/**
 * The unit test of ToPathConverter
 *
 * @author Brad Chen
 * @since 0.4.0
 */
public class ToPathConverterTest {
	@Test
	public void test(){
		Path path = new ToPathConverter().convert( "src/test/resources" );
		Assertions.assertEquals( "src" + System.getProperty( "file.separator" ) + "test" + System.getProperty( "file.separator" ) + "resources", path.toString() );
	}
}
