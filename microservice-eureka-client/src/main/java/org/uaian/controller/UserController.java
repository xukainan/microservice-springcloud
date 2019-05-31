package org.uaian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/5/30.
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("findOrderByUser")
    public String getOrderByUser(){
        int order_Id = 1;
        return this.restTemplate.getForObject("http://microservice-eureka-client-producer/order/"
                + order_Id,String.class);
    }
}
