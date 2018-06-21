package com.luotao.demo.sc.core.user;

import com.luotao.demo.sc.common.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 12:38
 */
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/userlist")
    @ResponseBody
    public User dc(@RequestParam("userid") Long userid) {

        logger.info("userid : " + userid);
        if (userid == 101) {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("12345678");
        if (System.currentTimeMillis() % 2 == 0 || System.currentTimeMillis() % 2 != 0) {
//            throw new BusiException(9999, new RuntimeException("test error"));
        }
        return user;
    }
}
