package com.example.proxy.pureproxy.deco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends ComponentInject{


    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("messageCompoennt");
        String operation = super.operation();
        String decoResult = "***"+operation+"***";
        return decoResult;
    }
}
