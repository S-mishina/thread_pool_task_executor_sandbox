package app.sandbox.sandbox_app.Controller;

import app.sandbox.sandbox_app.Util.ExecuteParallel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "TEST_ENDPOINT=http://dummy-endpoint")
public class ControllerTest {

    @Autowired
    private Controller controller;

    @MockitoBean
    private ExecuteParallel executeParallel;

    @Test
    public void testIndexWithoutHeader() {
        // HTTPリクエストの代わりに、Controllerのメソッドを直接呼び出して挙動を確認
        String result = controller.index(null);
        assertEquals("Bad parallel request", result);
    }

    @Test
    public void testIndexWithHeader() {
        // 正しいヘッダー値が渡された場合の挙動を確認
        String result = controller.index("5");
        assertEquals("parallel requestthreads:5", result);
    }
}
