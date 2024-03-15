package com.example.proxy.pureproxy.deco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

    private Component component;


    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator");
        String operation = component.operation();
        String decoResult = "시간 추가"+operation+"시간 추가";
        return decoResult;
    }
}
