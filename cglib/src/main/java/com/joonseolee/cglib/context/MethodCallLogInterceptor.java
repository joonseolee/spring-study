package com.joonseolee.cglib.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class MethodCallLogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
      log.info(">>> 로직이 실행되기전");
      Object value = methodProxy.invokeSuper(o, objects);
      log.info(">>> !!로직이 실행되기후!!");
      return value;
    }
}
