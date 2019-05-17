package com.luotao.demo.sc.hystrix;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:46
 */
@Component
public class HomeHandler {

    private static Logger logger = LoggerFactory.getLogger(HomeHandler.class);

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<ServerResponse> index(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromObject("helloworld"));
    }

    @Autowired
    RestTemplate restTemplate;

    public Mono<ServerResponse> list_res(ServerRequest request) {
        String url = "http://core-user/userlist?userid=" + 103;
        Mono<String> result = webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class);
        String user = result.block();
        System.out.println("String = " + user);
//
//        String result = restTemplate.getForEntity("http://core-user/userlist?userid=" + 103, String.class).getBody();
//        logger.info("result : " + result);


        return ServerResponse.ok().body(BodyInserters.fromObject("helloworld"));
    }
}
