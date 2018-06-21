package com.luotao.demo.sc.core.user;

import com.luotao.demo.sc.common.config.spring.WebConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
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
@ImportAutoConfiguration(classes = WebConfiguration.class)
public class MainCoreUser {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MainCoreUser.class).web(true).run(args);
    }
}
