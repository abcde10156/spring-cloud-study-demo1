package com.luotao.demo.sc.core.res.service;

import com.luotao.demo.sc.common.request.RequestIds;
import com.luotao.demo.sc.common.response.ResponseCommon;
import com.luotao.demo.sc.core.res.output.CompanyDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:15
 */
public interface CompanyService {


    @RequestMapping("/company/findDetailByIds")
    @ResponseBody
    ResponseCommon<List<CompanyDetail>> findDetailByIds(@RequestBody RequestIds requestIds);


}
