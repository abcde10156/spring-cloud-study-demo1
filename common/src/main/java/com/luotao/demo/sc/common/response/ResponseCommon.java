package com.luotao.demo.sc.common.response;

import com.luotao.demo.sc.common.IResponse;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 17:20
 */
public class ResponseCommon<T> implements IResponse {

    public ResponseCommon() {
    }

    T data;

    private int code = 0;

    private String message = "";

    private String tradeId = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public void setData(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }
}
