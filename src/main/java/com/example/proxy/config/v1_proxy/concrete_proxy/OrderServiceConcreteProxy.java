package com.example.proxy.config.v1_proxy.concrete_proxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v2.OrderRepositoryV2;
import com.example.proxy.v2.OrderServiceV2;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;


    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status  = logTrace.begin("OrderServiceV1.request()");
            target.orderItem(itemId);
            logTrace.end(status);

        }catch (Exception e){
            logTrace.exception(status,e);
        }
    }
}
