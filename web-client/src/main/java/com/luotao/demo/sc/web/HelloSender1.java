package com.luotao.demo.sc.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: luotao-pc
 * Date: 2018/7/18
 * Time: 20:32
 */
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        this.rabbitTemplate.convertAndSend("hello", message);
    }
}
