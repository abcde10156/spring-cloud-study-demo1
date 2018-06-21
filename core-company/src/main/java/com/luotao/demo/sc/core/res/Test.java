package com.luotao.demo.sc.core.res;


import com.luotao.demo.sc.common.response.ResponseCommon;
import com.luotao.demo.sc.core.res.output.CompanyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/21
 * Time: 23:00
 */
public class Test {
    public static void main(String[] args) throws Exception {
        CompanyDetail companyDetail = new CompanyDetail();
        companyDetail.setId(1L);
        companyDetail.setName("12321");
        List<CompanyDetail> companyDetails = new ArrayList<>();
        companyDetails.add(companyDetail);
        ResponseCommon<List<CompanyDetail>> responseCommon = new ResponseCommon<>();
        responseCommon.setData(companyDetails);

    }
}
