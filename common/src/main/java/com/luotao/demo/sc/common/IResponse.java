package com.luotao.demo.sc.common;


import java.io.Serializable;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 18:55
 */
public interface IResponse extends Serializable {
    int getCode();


    String getMessage();

}
