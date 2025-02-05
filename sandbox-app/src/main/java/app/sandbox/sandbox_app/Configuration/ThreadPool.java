package app.sandbox.sandbox_app.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;

@Configuration
public class ThreadPool {
  @Value("${threadpool.core-size:3}")
  private int corePoolSize;
  @Value("${threadpool.max-size:5}")
  private int maxPoolSize;
  @Value("${threadpool.queue-capacity:10}")
  private int queueCapacity;

  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    return new ThreadPoolTaskExecutorBuilder()
        .corePoolSize(corePoolSize)
        .maxPoolSize(maxPoolSize)
        .queueCapacity(queueCapacity)
        .threadNamePrefix("SyncThread-")
        .allowCoreThreadTimeOut(true)
        .build();
  }
}
