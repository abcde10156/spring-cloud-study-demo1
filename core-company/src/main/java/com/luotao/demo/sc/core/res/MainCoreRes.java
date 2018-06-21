package com.luotao.demo.sc.core.res;

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

public class MainCoreRes {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MainCoreRes.class).web(true).run(args);
    }
}
