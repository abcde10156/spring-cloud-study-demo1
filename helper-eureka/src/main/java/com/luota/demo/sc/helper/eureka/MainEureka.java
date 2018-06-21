package com.luota.demo.sc.helper.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:20
 */
@EnableEurekaServer
@SpringBootApplication
public class MainEureka {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MainEureka.class).web(true).run(args);
    }
}
