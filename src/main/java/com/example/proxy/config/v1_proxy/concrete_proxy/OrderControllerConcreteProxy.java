package com.example.proxy.config.v1_proxy.concrete_proxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v2.OrderControllerV2;
import com.example.proxy.v2.OrderServiceV2;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy( OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("orderController.request");
            String request = target.request(itemId);

            logTrace.end(status);
            return request;

        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}
