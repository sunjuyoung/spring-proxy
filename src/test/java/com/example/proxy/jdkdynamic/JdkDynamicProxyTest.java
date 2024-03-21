package com.example.proxy.jdkdynamic;

import com.example.proxy.jdkdynamic.code.AImpl;
import com.example.proxy.jdkdynamic.code.AInterface;
import com.example.proxy.jdkdynamic.code.TimeInvocationHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA(){
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface)Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class},
                handler);
        proxy.call();  //method.invoke(target,args);
        log.info("targetClass={}",target.getClass());
        log.info("proxyClass={}",proxy.getClass());
    }
}
