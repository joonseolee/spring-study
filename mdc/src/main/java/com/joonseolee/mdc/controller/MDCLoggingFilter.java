package com.joonseolee.mdc.controller;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class MDCLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestId = ((HttpServletRequest) request).getHeader("X-RequestID");
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        MDC.put("request_id", requestId == null ? uuid : requestId);

        chain.doFilter(request, response);

        MDC.clear();
    }
}
