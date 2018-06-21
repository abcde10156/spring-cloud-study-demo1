package com.luotao.demo.sc.web;

import com.luotao.demo.sc.common.service.ClipService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:36
 */
@FeignClient(value = "res-service",configuration = FeginConfig.class)
interface ClipServiceClient extends ClipService {

}
