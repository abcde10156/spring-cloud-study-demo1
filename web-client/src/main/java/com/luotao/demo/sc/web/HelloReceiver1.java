package com.luotao.demo.sc.web;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * User: luotao-pc
 * Date: 2018/7/18
 * Time: 20:32
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {
    @RabbitHandler
    public void process(String hello) {
        if (hello.equals("hello")) {
            throw new RuntimeException("test");
        }
        System.out.println("OK");
//        throw new RuntimeException("test");
    }
}
