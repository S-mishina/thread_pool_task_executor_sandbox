package app.sandbox.sandbox_app.Controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.sandbox.sandbox_app.Utils;

@RestController
public class Controller {
  @GetMapping("/")
  public String index(@RequestHeader HttpHeaders headers) {
    List<String> testAppHeader = headers.get("test-app");
    int parallelRequests = 1;
    if (testAppHeader != null && !testAppHeader.isEmpty()) {
      try {
        int value = Integer.parseInt(testAppHeader.get(0));
        if (value > 0) {
          parallelRequests = value;
        }
      } catch (NumberFormatException e) {
        parallelRequests = 1;
      }
    }
    return Utils.ExecuteParallelHttpRequest(parallelRequests);
  }
}
