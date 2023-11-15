package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "greeting")
public class GreetConfig {
    private Map<String, Map<String, String>> times;
}

