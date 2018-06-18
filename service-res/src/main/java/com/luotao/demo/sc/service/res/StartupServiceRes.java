package com.luotao.demo.sc.service.res;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:37
 */
@EnableDiscoveryClient
@SpringBootApplication

public class StartupServiceRes {
    public static void main(String[] args) {
        new SpringApplicationBuilder(StartupServiceRes.class).web(true).run(args);
    }
}
