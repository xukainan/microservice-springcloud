package org.uaian.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.uaian.ServiceInfoUtil;
import org.uaian.pojo.Order;

/**
 * Created by Administrator on 2019/5/30.
 */
@RestController
public class OrderController {

    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable String id){
        Order order = new Order("1","xukainan","xilinhaote","15147952343",99.99);
        System.out.println(ServiceInfoUtil.getPort());
        return order.toString();
    }
}
