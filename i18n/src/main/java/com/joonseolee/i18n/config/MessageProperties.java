package com.joonseolee.i18n.config;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public abstract class MessageProperties {
    abstract String getGreeting();
    abstract String getName();
    final Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }
}
