package com.example.proxy.config.v1_proxy.interface_proxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v1.OrderControllerV1;
import com.example.proxy.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;

public class OrderControllerInterfaceProxy extends  OrderControllerV1{



    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    public OrderControllerInterfaceProxy(OrderServiceV1 orderServiceV1, OrderControllerV1 target, LogTrace logTrace) {
        super(orderServiceV1);
        this.target = target;
        this.logTrace = logTrace;
    }




    public String request(String itemId){
        TraceStatus status = null;
        try {
            status = logTrace.begin("orderController.request");
            String request = target.request(itemId);

            logTrace.end(status);
            return request;

        }catch (Exception e){
            logTrace.exception(status,e);
            throw  e;
        }


    }



}
