package com.example.proxy.config.v3_proxyFactory;

import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v1.OrderRepositoryV1;
import com.example.proxy.v1.OrderRepositoryV1Impl;
import com.example.proxy.v2.OrderRepositoryV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV2 {



    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace){
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();

        ProxyFactory fac = new ProxyFactory(orderRepositoryV1);
        fac.addAdvisor(getAdvisor(logTrace));
        OrderRepositoryV2 proxy = (OrderRepositoryV2)fac.getProxy();
        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*","order*","save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut,advice);
    }
}
