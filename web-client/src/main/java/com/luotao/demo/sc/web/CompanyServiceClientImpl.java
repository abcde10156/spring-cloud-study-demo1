package com.luotao.demo.sc.web;

import com.luotao.demo.sc.common.request.RequestIds;
import com.luotao.demo.sc.common.response.ResponseCommon;
import com.luotao.demo.sc.core.res.output.CompanyDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/22
 * Time: 20:13
 */

@Component
public class CompanyServiceClientImpl implements CompanyServiceClient {
    @Override
    public ResponseCommon<List<CompanyDetail>> findDetailByIds(@RequestBody RequestIds requestIds) {
        return null;
    }
}
