package com.joonseolee.i18n.controller;

import com.joonseolee.i18n.config.MessageProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/home")
public class MainController {

    private final MessageSource messageSource;
    private final MessageProperties englishMessageProperties;
    private final MessageProperties koreanMessageProperties;

    public MainController(MessageSource messageSource,
                          @Qualifier("englishMessageProperties") MessageProperties englishMessageProperties,
                          @Qualifier("koreanMessageProperties") MessageProperties koreanMessageProperties) {
        this.messageSource = messageSource;
        this.englishMessageProperties = englishMessageProperties;
        this.koreanMessageProperties = koreanMessageProperties;
    }

    @GetMapping("/properties")
    public Locale getProperties() {
        return LocaleContextHolder.getLocale();
    }
}
