package com.luotao.demo.sc.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:46
 */
@RestController
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Object helloController(@RequestParam(name = "id") Long id) {
        logger.info(IndexController.class.getName());


        String result = consumerService.consumer(id);
        logger.info("result : " + result);

        return result;
    }

    @Service
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer(Long id) {
            return restTemplate.getForObject("http://core-user/userlist?userid=" + id, String.class);
        }

        public String fallback(Long id) {
            System.out.println("info fallback");
            return "fallback";
        }

    }
}
