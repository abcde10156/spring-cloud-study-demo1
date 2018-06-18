package com.luotao.demo.sc.service;

import com.luotao.demo.sc.request.RequestIds;
import com.luotao.demo.sc.response.ResponseClipDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:15
 */
public interface ClipService {


    @RequestMapping("/clip/detail")
    ResponseClipDetail detailById(@RequestBody RequestIds requestIds);

    @RequestMapping("/clip/findById")
    ResponseClipDetail findById(@RequestParam(name = "id") Long id);
}
