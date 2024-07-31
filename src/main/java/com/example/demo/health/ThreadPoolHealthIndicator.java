package com.example.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("MyThreadPool-");
        executor.initialize();


        if (executor.getCorePoolSize() < executor.getMaxPoolSize()) {
            return Health.up()
                    .withDetail("poolSize", executor.getCorePoolSize())
                    .withDetail("maxPoolSize", executor.getMaxPoolSize())
                    .withDetail("queueSize", executor.getQueueCapacity())
                    .build();
        } else {
            return Health.down()
                    .withDetail("poolSize", executor.getCorePoolSize())
                    .withDetail("maxPoolSize", executor.getMaxPoolSize())
                    .withDetail("queueSize", executor.getQueueCapacity())
                    .build();
        }
    }

}
