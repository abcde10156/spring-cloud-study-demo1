package com.luotao.demo.sc.common.response;

import com.luotao.demo.sc.common.ResponseCommon;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 22:17
 */
public class ResponseClipDetail extends ResponseCommon {
    Long id;

    String name;

    String md5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
