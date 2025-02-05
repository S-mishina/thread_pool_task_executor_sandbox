package main.java.app.sandbox.sandbox_app.Utils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecuteParallel {

  public static List<String> ExecuteParallelHttpRequest(int parallelCount) {
    String url = System.getenv("TEST_ENDPOINT");
    if (url == null) {
      return "TEST_ENDPOINT environment variable is not set";
    } else {
      List<CompletableFuture<String>> futureList = IntStream.range(0, parallelCount)
          .mapToObj(i -> CompletableFuture.supplyAsync(() -> httpRequest(url), asyncTaskExecutor))
          .collect(Collectors.toList());
      CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
      return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
  }

}
