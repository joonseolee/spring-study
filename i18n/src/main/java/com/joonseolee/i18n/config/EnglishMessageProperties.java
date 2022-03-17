package com.joonseolee.i18n.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Setter
@Configuration
@PropertySource(value = "classpath:messages.yml", factory = YmlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "context")
public class EnglishMessageProperties {
    private String greeting;
    private String name;

    String getGreeting() {
        return greeting;
    }

    String getName() {
        return name;
    }
}
