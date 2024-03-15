package com.example.proxy.pureproxy.deco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

    private Component component;


    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("messageCompoennt");
        String operation = component.operation();
        String decoResult = "***"+operation+"***";
        return decoResult;
    }
}
