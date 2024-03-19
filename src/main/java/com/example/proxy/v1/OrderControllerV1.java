package com.example.proxy.v1;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;



    @GetMapping("/v1/request")
    public String request(@RequestParam("itemId")String itemId){

        orderServiceV1.orderItem(itemId);
        return "ok";
    }
}
