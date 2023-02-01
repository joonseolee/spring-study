package com.joonseolee.enc.controller;

import com.joonseolee.enc.config.DatasourcePropertiesConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
@RequiredArgsConstructor
public class BaseController {

    private final DatasourcePropertiesConfiguration datasourcePropertiesConfiguration;

    @GetMapping
    public String dfsdf() {
        return datasourcePropertiesConfiguration.getUrl();
    }
}
