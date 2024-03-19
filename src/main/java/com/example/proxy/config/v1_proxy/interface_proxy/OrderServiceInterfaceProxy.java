package com.example.proxy.config.v1_proxy.interface_proxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

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
