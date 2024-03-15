package com.example.proxy.pureproxy.deco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorClient {

    private Component component;

    public DecoratorClient(Component component) {
        this.component = component;
    }

    public void execute(){
        String operation = component.operation();
        log.info("result ={}",operation);
    }
}
