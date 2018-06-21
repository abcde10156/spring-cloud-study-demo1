package com.luotao.demo.sc.common;


/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 18:56
 */
public class BusinessException extends RuntimeException implements IResponse {

    Throwable throwable;


    int code;

    private String message = "";

    public BusinessException(int code, Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
        this.code = code;
        this.message = throwable.getMessage();
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
