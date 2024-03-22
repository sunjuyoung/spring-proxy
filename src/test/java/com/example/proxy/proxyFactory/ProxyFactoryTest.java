package com.example.proxy.proxyFactory;

import com.example.proxy.common.advice.TimeAdvice;
import com.example.proxy.common.service.ConcreteService;
import com.example.proxy.common.service.ServiceImpl;
import com.example.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 jdk 동적 프록시 사용")
    void interfaceProxy(){

        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy =  (ServiceInterface)proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertFalse(AopUtils.isCglibProxy(proxy));
    }

    @Test
    @DisplayName("구체클래스 cglib 동적 프록시 사용")
    void concreteProxy(){

        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy =  (ConcreteService)proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertFalse(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }

    @Test
    @DisplayName("proxyTargetClass 옵션 사용")
    void proxyTargetClass(){

        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy =  (ServiceInterface)proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertFalse(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }
}
