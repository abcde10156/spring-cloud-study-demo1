package com.luotao.demo.sc.web;

/**
 * User: luotao-pc
 * Date: 2018/7/18
 * Time: 20:33
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class RabbitTest2 {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;

    @GetMapping("/hello2")
    public void hello() {
        helloSender2.send();
    }
}
