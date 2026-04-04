package app.sandbox.sandbox_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "TEST_ENDPOINT=http://dummy-endpoint")
class SandboxAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
