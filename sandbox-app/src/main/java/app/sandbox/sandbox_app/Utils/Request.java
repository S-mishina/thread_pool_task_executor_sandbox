package app.sandbox.sandbox_app.Util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import io.opentelemetry.instrumentation.annotations.WithSpan;

public class Request {

  @WithSpan
  public static void httpRequest(String url) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    System.out.println(response.getBody());
    return response.getBody();
  }
}
