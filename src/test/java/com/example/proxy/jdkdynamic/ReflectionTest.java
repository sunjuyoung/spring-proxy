package com.example.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflectionV1(){
        Hello target = new Hello();

        //공통 로직 1 시작
        log.info("start");
        String s = target.callA();
        log.info("end result ={}",s);
        //공통 로직 1 종료


        //공통 로직 2 시작
        log.info("start");
        String s1 = target.callB();
        log.info("end result ={}",s1);
        //공통 로직 2 종료
    }

    @Test
    void ref() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classHello = Class.forName("com.example.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        //메타데이타
        Method callA = classHello.getMethod("callA");

        //메타데이터에서 실제 인스턴스메서드 호출
        Object result1 = callA.invoke(target);
        log.info("reesult ={}",result1);



    }

    @Slf4j
    static class Hello{
        public String callA(){
            log.info("callA");
            return "A";
        }

        public String callB(){
            log.info("callB");
            return "B";
        }
    }
}
