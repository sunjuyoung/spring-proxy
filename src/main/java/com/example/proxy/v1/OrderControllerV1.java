package com.example.proxy.v1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;

    public OrderControllerV1(OrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @GetMapping("/v1/request")
    public String request(@RequestParam("itemId")String itemId){

        return "ok";
    }
}
