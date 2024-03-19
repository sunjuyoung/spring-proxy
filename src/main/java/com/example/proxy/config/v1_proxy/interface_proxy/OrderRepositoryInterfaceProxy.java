package com.example.proxy.config.v1_proxy.interface_proxy;

import com.example.proxy.v1.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 orderRepositoryV1;


    @Override
    public void save(String itemId) {

    }
}
