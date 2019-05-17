package com.luotao.demo.sc.hystrix;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:46
 */
@Component
public class HomeHandler {

    private static Logger logger = LoggerFactory.getLogger(HomeHandler.class);


    public Mono<ServerResponse> index(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromObject("helloworld"));
    }

    public Mono<ServerResponse> list_res(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromObject("helloworld"));
    }
}
