package com.luotao.demo.sc.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: luotao-pc
 * Date: 2018/7/18
 * Time: 20:32
 */
@Component
public class HelloSender2 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello2 " + new Date();
        System.out.println("Sender2 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("user", sendMsg);
    }
}
