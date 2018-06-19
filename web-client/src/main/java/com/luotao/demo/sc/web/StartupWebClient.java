package com.luotao.demo.sc.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:37
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class StartupWebClient extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StartupWebClient.class);
    }


    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
//        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//        simpleClientHttpRequestFactory.setConnectTimeout(1000);
//        simpleClientHttpRequestFactory.setReadTimeout(1000);
//        return new RestTemplate(simpleClientHttpRequestFactory);
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(StartupWebClient.class).web(true).run(args);
    }
}
