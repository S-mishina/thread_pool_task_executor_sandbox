package app.sandbox.sandbox_app.Util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class ExecuteParallel {
  private final ThreadPoolTaskExecutor asyncTaskExecutor;

  // コンストラクタでasyncTaskExecutorを初期化
  public ExecuteParallel(ThreadPoolTaskExecutor asyncTaskExecutor) {
    this.asyncTaskExecutor = asyncTaskExecutor;
  }

  public List<String> executeParallelHttpRequest(int parallelCount) {
    String url = "https://yahoo.jp/";
    if (url == null) {
      return List.of("TEST_ENDPOINT environment variable is not set");
    } else {
      List<CompletableFuture<String>> futureList = IntStream.range(0, parallelCount)
          .mapToObj(i -> CompletableFuture.supplyAsync(() -> Request.httpRequest(url), asyncTaskExecutor))
          .collect(Collectors.toList());
      CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
      return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
  }
}
