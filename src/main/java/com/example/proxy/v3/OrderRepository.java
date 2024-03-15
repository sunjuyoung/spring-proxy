package com.example.proxy.v3;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public void save(String itemId) {
        if(itemId.equals("ex")){
            throw  new IllegalStateException("예외 발생");
        }

        sleep(1000);
    }

    private void sleep(int min){
        try {
            Thread.sleep(min);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
