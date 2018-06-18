package com.luotao.demo.sc.web;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * User: luotao-pc
 * Date: 2018/6/16
 * Time: 01:41
 */
@Configuration
public class FeginConfig {
    @Bean
    public Retryer feginRetryer(){
        Retryer retryer = new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), -1);
        return retryer;
    }
}