package com.luotao.demo.sc;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 17:20
 */
public class ResponseCommon<T> {

    T data;

    private int code;

    private String message;

    private String tradeId;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

    public static <T> ResponseCommon success(int code, String message, T data) {
        ResponseCommon<T> responseCommon = new ResponseCommon<>();
        responseCommon.setCode(code);
        responseCommon.setMessage(message);
        responseCommon.setData(data);
        return responseCommon;
    }

    public static <T> ResponseCommon fail(int code, String tradeId,String message, Throwable data) {
        ResponseCommon<T> responseCommon = new ResponseCommon<>();
        responseCommon.setCode(code);
        responseCommon.setMessage(message);
        responseCommon.setTradeId(tradeId);
        return responseCommon;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }
}
