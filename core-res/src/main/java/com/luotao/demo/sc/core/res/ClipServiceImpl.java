package com.luotao.demo.sc.core.res;

import com.luotao.demo.sc.common.BusiException;
import com.luotao.demo.sc.common.request.RequestIds;
import com.luotao.demo.sc.common.response.ResponseClipDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:15
 */
@RestController
public class ClipServiceImpl implements ClipService {

    Logger logger = LoggerFactory.getLogger(ClipServiceImpl.class);

    @Override
    public ResponseClipDetail detailById(@RequestBody RequestIds requestIds) {
        logger.info("requestIds.getId() = " + requestIds.getId());
        if (requestIds.getId() == 100L) {
            throw new BusiException(300001, new RuntimeException("id错误"));
        }
        if (requestIds.getId() == 101L) {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Long id = System.currentTimeMillis();
        ResponseClipDetail responseClipDetail = new ResponseClipDetail();
        responseClipDetail.setId(id);
        responseClipDetail.setMd5("md5_" + id);
        responseClipDetail.setName("name_" + id);
        return responseClipDetail;
    }


    @Override
    public ResponseClipDetail findById(@RequestParam(name = "id") Long id) {
        System.out.println("id = " + id);
        ResponseClipDetail responseClipDetail = new ResponseClipDetail();
        responseClipDetail.setId(10000L);
        responseClipDetail.setMd5("md5_" + id);
        responseClipDetail.setName("name_" + id);
        return responseClipDetail;
    }
}
