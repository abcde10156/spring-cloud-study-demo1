package com.luotao.demo.sc.web;

import com.luotao.demo.sc.request.RequestIds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);


    @Autowired
    ClipServiceClient clipService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public Object helloController(@RequestParam(name = "id") Long id) {
        logger.info(ConsumerController.class.getName());
        logger.info("clipService : " + clipService);


//        ResponseClipDetail byId = clipService.findById(110L);
//        logger.info("clipDetail1 : " + byId.getId());

        RequestIds requestIds = new RequestIds();
        requestIds.setId(id);
        Object clipDetail = clipService.detailById(requestIds);

        String result = restTemplate.getForEntity("http://user-service/userlist", String.class).getBody();
        logger.info("result : " + result);

        return clipDetail;
    }
}
