package com.luotao.demo.sc.hystrix;

//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.*;

/**
 * @author think
 *         date   2019-05-17 14:42
 */
@Configuration
public class Router {


    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
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

    @Bean
    public RouterFunction<ServerResponse> routeCity(HomeHandler indexHandler) {

        RequestPredicate accept = RequestPredicates.accept(MediaType.TEXT_PLAIN);


        return RouterFunctions
                .route(RequestPredicates.GET("/index").and(accept), indexHandler::index)
                .andRoute(RequestPredicates.GET("/list_res").and(accept), indexHandler::list_res)
                ;

    }

}
