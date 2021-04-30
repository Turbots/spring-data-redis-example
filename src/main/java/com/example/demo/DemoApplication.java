package com.example.demo;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import io.lettuce.core.TimeoutOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Duration;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
        return p -> p.clientOptions(ClientOptions.builder()
                .timeoutOptions(TimeoutOptions.builder()
                        .connectionTimeout().fixedTimeout(Duration.ofSeconds(2L))
                        .build())
                .socketOptions(SocketOptions.builder()
                        .connectTimeout(Duration.ofSeconds(2L))
                        .build())
                .build())
                .build();
    }
}
