package com.example.proxy.pureproxy.deco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component{



    @Override
    public String operation() {
        log.info("realcomponent 실행");
        return "data";
    }
}
