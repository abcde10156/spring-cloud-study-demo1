package com.luotao.demo.sc.common;

/**
 * User: luotao-pc
 * Date: 2018/6/21
 * Time: 20:28
 */
public class CommonException {

    public static final int code_known_error = 9999999;

    public static final BusinessException illegalInput = new BusinessException(9990001, "输入参数错误");
    public static final BusinessException illegalOutput = new BusinessException(9990002, "返回结果不能为空");
    public static final BusinessException unknown = new BusinessException(code_known_error, "未知错误");
}
