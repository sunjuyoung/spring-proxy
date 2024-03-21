package com.example.proxy.config.v2_dynamicproxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceBasicHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace logTrace;

    public LogTraceBasicHandler(Object object, LogTrace logTrace) {
        this.target = object;
        this.logTrace = logTrace;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        TraceStatus status = null;
        try {
            String message = method.getDeclaringClass().getSimpleName()+"."+method.getName()+"()";
            status  = logTrace.begin(message);


            Object result = method.invoke(target, args);
            logTrace.end(status);
            return result;

        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
