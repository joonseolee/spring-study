package com.joonseolee.i18n.config;

import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Setter
@Configuration
@PropertySource(value = "classpath:messages.properties")
//@ConfigurationProperties(prefix = "context")
public class KoreanMessageProperties extends MessageProperties {

    private String greeting;
    private String name;

//    @ConstructorBinding
//    public KoreanMessageProperties(String greeting, String name) {
//        this.greeting = greeting;
//        this.name = name;
//    }

    @Override
    String getGreeting() {
        return greeting;
    }

    @Override
    String getName() {
        return name;
    }
}
