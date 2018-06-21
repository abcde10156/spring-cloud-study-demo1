package com.luotao.demo.sc.web;

import com.luotao.demo.sc.common.request.RequestIds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:46
 */
@RestController
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);


    @Autowired
    CompanyServiceClient companyServiceClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public Object helloController(@RequestParam(name = "id") Long id) {
        logger.info(ConsumerController.class.getName());
        logger.info("companyServiceClient : " + companyServiceClient);


//        ResponseClipDetail byId = clipService.findById(110L);
//        logger.info("clipDetail1 : " + byId.getId());

        RequestIds requestIds = new RequestIds();
        requestIds.setId(Arrays.asList(id, 9999L));
        Object clipDetail = companyServiceClient.findDetailByIds(requestIds);
        logger.info("clipDetail : " + clipDetail);
        String result = restTemplate.getForEntity("http://core-user/userlist?userid=" + id, String.class).getBody();
        logger.info("result : " + result);

        return clipDetail;
    }
}
