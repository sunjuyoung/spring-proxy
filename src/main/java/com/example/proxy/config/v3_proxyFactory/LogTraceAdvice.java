package com.example.proxy.config.v3_proxyFactory;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;


public class LogTraceAdvice implements MethodInterceptor {

    private final LogTrace logTrace;

    public LogTraceAdvice(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        TraceStatus status = null;
        try {
            Method method = invocation.getMethod();
            String message = method.getDeclaringClass().getSimpleName()+"."+method.getName()+"()";
            status  = logTrace.begin(message);


            Object result = invocation.proceed();
            logTrace.end(status);
            return result;

        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
