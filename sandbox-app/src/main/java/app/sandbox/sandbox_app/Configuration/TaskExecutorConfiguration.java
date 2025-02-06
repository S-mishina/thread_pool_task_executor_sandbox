package app.sandbox.sandbox_app.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfiguration {
  private final int maxPoolSize;
  private final int corePoolSize;
  private final int queueCapacity;

  public TaskExecutorConfiguration(
      @Value("${threadpool.max-size:5}") int maxPoolSize,
      @Value("${threadpool.core-size:3}") int corePoolSize,
      @Value("${threadpool.queue-capacity:10}") int queueCapacity) {
    this.maxPoolSize = maxPoolSize;
    this.corePoolSize = corePoolSize;
    this.queueCapacity = queueCapacity;
  }

  @Bean
  public ThreadPoolTaskExecutor asyncTaskExecutor() {
    return new ThreadPoolTaskExecutorBuilder()
        .corePoolSize(corePoolSize)
        .maxPoolSize(maxPoolSize)
        .queueCapacity(queueCapacity)
        .threadNamePrefix("async-task-executor-")
        .allowCoreThreadTimeOut(true)
        .build();
  }
}
