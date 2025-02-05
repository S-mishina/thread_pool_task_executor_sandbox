package app.sandbox.sandbox_app.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.sandbox.sandbox_app.Util.ExecuteParallel;

@RestController
public class Controller {
  @GetMapping("/")
  public String index(@RequestHeader(value = "test-app", required = false) String testAppHeader) {
    int parallelRequests = 1;
    if (testAppHeader != null) {
      try {
        int value = Integer.parseInt(testAppHeader);
        if (value > 0) {
          parallelRequests = value;
        }
      } catch (NumberFormatException e) {
        parallelRequests = 1;
      }
    }
    return String.join(", ", ExecuteParallel.ExecuteParallelHttpRequest(parallelRequests));
  }
}
