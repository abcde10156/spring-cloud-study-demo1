package com.luotao.demo.sc.web;


import com.luotao.demo.sc.core.res.service.CompanyService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:36
 */
@FeignClient(value = "core-company", fallback = CompanyServiceClientImpl.class)
interface CompanyServiceClient extends CompanyService {

}
