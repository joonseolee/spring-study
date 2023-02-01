package com.joonseolee.enc;

import com.joonseolee.enc.config.DatasourcePropertiesConfiguration;
import com.joonseolee.enc.config.SampleProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
        DatasourcePropertiesConfiguration.class,
        SampleProperties.class
})
public class EncApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncApplication.class, args);
    }

}
