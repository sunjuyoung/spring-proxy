package com.example.proxy.pureproxy.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{

    @Override
    public String operation() {

        log.info("실제 객체 호출");
        sleep(1000);
        return "data";
    }

    private void sleep(int mill){
        try {
            Thread.sleep(mill);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
