package com.example.proxy.config.v1_proxy.interface_proxy;

import com.example.proxy.TraceStatus;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.v1.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;


    @Override
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
