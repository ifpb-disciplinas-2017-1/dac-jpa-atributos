package ifpb.ads.jpa.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class SmartPathTest {

    private final SmartPath instance = new SmartPath();

    @Test
    public void testToBytes() throws Exception {
        System.out.println("toBytes");
        byte[] result = instance.toBytes();
        assertNotNull(result);
        assertTrue(result.length > 0);
    }

    @Test
    public void testLines() throws Exception {
        System.out.println("lines");
        Stream<String> result = instance.lines();
        assertNotNull(result);
        assertTrue(result.count() == 3);
    }

}
