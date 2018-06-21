package com.luotao.demo.sc.common.request;

import com.luotao.demo.sc.common.RequestCommon;

import java.util.ArrayList;
import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:13
 */
public class RequestIds extends RequestCommon {
    private List<Long> id = new ArrayList<>();

    public RequestIds() {
    }

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }
}
