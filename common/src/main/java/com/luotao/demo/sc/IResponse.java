package com.luotao.demo.sc;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 18:55
 */
public interface IResponse<T> {
    public T getData();


    public int getCode();


    public String getMessage();

}
