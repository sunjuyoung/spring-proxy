package com.example.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Timeproxy 실행");
        long start = System.currentTimeMillis();

        Object invoke = method.invoke(target,args);



        long end = System.currentTimeMillis();

        long result = end - start;

        log.info("timeproxy 종료 resultTime = {}",result);

        return invoke;
    }
}