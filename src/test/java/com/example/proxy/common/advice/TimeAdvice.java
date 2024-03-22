package com.example.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        log.info("Timeproxy 실행");
        long start = System.currentTimeMillis();

        Object invoke = invocation.proceed();

        long end = System.currentTimeMillis();

        long result = end - start;

        log.info("timeproxy 종료 resultTime = {}",result);
        return invoke;
    }
}
