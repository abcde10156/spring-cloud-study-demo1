package com.luotao.demo.sc.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:37
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MainWebClientFlux {

    public static void main(String[] args) {
        SpringApplication.run(MainWebClientFlux.class, args);
    }
}
