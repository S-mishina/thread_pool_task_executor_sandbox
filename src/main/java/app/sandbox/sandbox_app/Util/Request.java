package app.sandbox.sandbox_app.Util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import io.opentelemetry.instrumentation.annotations.WithSpan;

public class Request {

  @WithSpan
  public static String httpRequest(String url) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    return response.getBody();
  }
}
