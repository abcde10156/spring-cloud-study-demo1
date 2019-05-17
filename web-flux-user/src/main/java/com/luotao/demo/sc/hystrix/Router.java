package com.luotao.demo.sc.hystrix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @author think
 *         date   2019-05-17 14:42
 */
@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> routeCity(HomeHandler indexHandler) {

        RequestPredicate accept = RequestPredicates.accept(MediaType.TEXT_PLAIN);


        return RouterFunctions
                .route(RequestPredicates.GET("/index").and(accept), indexHandler::index)
                .andRoute(RequestPredicates.GET("/findUser").and(accept), indexHandler::list_res)
                ;

    }

}
