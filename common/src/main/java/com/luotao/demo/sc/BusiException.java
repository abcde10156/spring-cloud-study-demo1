package com.luotao.demo.sc;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 18:56
 */
public class BusiException extends RuntimeException implements IResponse {

    Throwable throwable;

    int code;

    public BusiException(int code, Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
        this.code = code;
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return throwable.getMessage();
    }
}
