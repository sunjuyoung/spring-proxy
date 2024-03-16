package com.example.proxy.pureproxy.deco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator extends ComponentInject {
    public TimeDecorator(Component component) {
        super(component);
    }


//    private Component component;
//
//
//    public TimeDecorator(Component component) {
//        this.component = component;
//    }

    @Override
    public String operation() {
        log.info("TimeDecorator");

        String operation = super.operation();
        String decoResult = "시간 추가"+operation+"시간 추가";
        return decoResult;


    }
}
