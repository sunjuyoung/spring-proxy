package com.example.proxy.config.v1_proxy;

import com.example.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.example.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.example.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {


    @Bean
    public OrderControllerInterfaceProxy orderControllerV1(LogTrace logTrace){
        OrderControllerV1 orderControllerV1 = new OrderControllerV1(orderServiceV1(logTrace));
        return new OrderControllerInterfaceProxy(orderServiceV1(logTrace),orderControllerV1,logTrace);
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceV1,logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryV1,logTrace);
    }
}
