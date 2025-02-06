package app.sandbox.sandbox_app.Controller;

import app.sandbox.sandbox_app.Util.ExecuteParallel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Controller {
  private final ExecuteParallel executeParallel;

  @Autowired
  public Controller(ExecuteParallel executeParallel) {
    this.executeParallel = executeParallel;
  }

  @GetMapping("/")
  public String index(@RequestHeader(value = "test-app", required = false) String testAppHeader) {
    int parallelRequests = 1;

    if (testAppHeader != null) {
      try {
        parallelRequests = Integer.parseInt(testAppHeader);
      } catch (NumberFormatException e) {
        parallelRequests = 1;
      }

      executeParallel.executeParallelHttpRequest(parallelRequests);
      return "Accessed Yahoo!";
    } else {
      return "Hello World!";
    }
  }
}
