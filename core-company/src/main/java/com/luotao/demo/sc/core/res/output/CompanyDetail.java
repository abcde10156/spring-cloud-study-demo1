package com.luotao.demo.sc.core.res.output;

import java.io.Serializable;

/**
 * User: luotao-pc
 * Date: 2018/6/21
 * Time: 20:20
 */
public class CompanyDetail implements Serializable {
    private Long id;

    private String name;

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
}
