package com.joonseolee.enc.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties(prefix = "sample.datasource")
public class SampleProperties {

    private final String url;
    private final String username;
    private final String password;

    @ConstructorBinding
    public SampleProperties(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
