package app.sandbox.sandbox_app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @GetMapping("/")
  public String index() {
    return "{\"message\": \"Hello World!\"}";
  }
}
