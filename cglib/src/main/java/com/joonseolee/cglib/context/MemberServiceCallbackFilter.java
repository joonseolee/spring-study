package com.joonseolee.cglib.context;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class MemberServiceCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().equals("registration")) {
            return 0;
        }
        return 1;
    }
}
