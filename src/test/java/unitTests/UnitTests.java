package unitTests;

import static org.junit.Assert.assertTrue;
import com.spitter.web.HelloWorldController;
import org.junit.Test;

public class UnitTests {
    @Test
    public void testHelloWorldController(){
        HelloWorldController controller = new HelloWorldController();
        assertTrue(controller.display().contains("lavazhagan"));
    }
}
