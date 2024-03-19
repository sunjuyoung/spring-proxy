package com.example.proxy.config.v1_proxy.concrete_proxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status  = logTrace.begin("OrderRepositoryV1.request()");
            target.save(itemId);
            logTrace.end(status);

        }catch (Exception e){
            logTrace.exception(status,e);
        }
    }
}
