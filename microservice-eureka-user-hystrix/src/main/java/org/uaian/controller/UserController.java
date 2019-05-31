package org.uaian.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/5/31.
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getOrderByUser",produces = "application/json; charset=utf-8")
    @HystrixCommand(fallbackMethod = "fallbackInfo")
    public String getOrderByUser(){
        int order_Id = 1;
        return this.restTemplate.getForObject("http://microservice-eureka-client-producer/order/"
                + order_Id,String.class);
    }

    /**
     * 回调方法，有HystrixCommand指定，但是必须与原方法参事保持一致
     * @return
     */
    public String fallbackInfo(){
        return  new String("no serice!");
    }
}
