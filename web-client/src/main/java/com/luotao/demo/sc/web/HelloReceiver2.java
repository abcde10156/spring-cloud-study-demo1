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
@RabbitListener(queues = "user")
public class HelloReceiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);

    }
}
