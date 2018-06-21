package com.luotao.demo.sc.core.res.service.impl;

import com.luotao.demo.sc.common.CommonException;
import com.luotao.demo.sc.common.request.RequestIds;
import com.luotao.demo.sc.common.response.ResponseCommon;
import com.luotao.demo.sc.core.res.output.CompanyDetail;
import com.luotao.demo.sc.core.res.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:15
 */
@RestController
public class CompanyServiceImpl implements CompanyService {

    Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Override
    @ResponseBody
    public ResponseCommon<List<CompanyDetail>> findDetailByIds(@RequestBody RequestIds requestIds) {
        logger.info("requestIds.getId() = " + requestIds.getId());
        if (requestIds.getId().size() > 0) {
            if (requestIds.getId().get(0) == 100L) {
                throw CommonException.illegalInput;
            }
            if (requestIds.getId().get(0) == 101L) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Long id = System.currentTimeMillis();
        CompanyDetail responseClipDetail = new CompanyDetail();
        responseClipDetail.setId(id);
        responseClipDetail.setName("name_" + id);

        ResponseCommon<List<CompanyDetail>> responseCommon = new ResponseCommon<>();
        List<CompanyDetail> result = new ArrayList<>();
        result.add(responseClipDetail);
        responseCommon.setData(result);

        return responseCommon;
    }
}
