import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.spitter.web.HelloWorldController;
import com.spitter.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MockTests {

    @Test
    public void testHelloWordPage() throws Exception{
        HelloWorldController controller = new HelloWorldController();
        MockMvc mockMvc;
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/")).
                andExpect(view().name("Hello Word! Elavazhagan Sethuraman"));
    }

    @Test
    public void testHomePage() throws Exception{
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform((get("/"))).andExpect(view().name("homepage"));
    }
}
