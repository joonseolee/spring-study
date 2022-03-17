package com.joonseolee.i18n.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

@Slf4j
public class YmlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        var yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(resource.getResource());
        var property = yamlPropertiesFactoryBean.getObject();

        if (resource.getResource().getFilename() == null || property == null) {
            log.warn("cannot load yaml files.");
            return null;
        }

        return new PropertiesPropertySource(resource.getResource().getFilename(), property);
    }
}