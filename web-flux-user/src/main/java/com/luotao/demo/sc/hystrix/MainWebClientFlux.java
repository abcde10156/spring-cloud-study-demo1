package com.luotao.demo.sc.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:37
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableEurekaClient
//@EnableDiscoveryClient
//@SpringCloudApplication
public class MainWebClientFlux {

    public static void main(String[] args) {
        SpringApplication.run(MainWebClientFlux.class, args);
    }
}
