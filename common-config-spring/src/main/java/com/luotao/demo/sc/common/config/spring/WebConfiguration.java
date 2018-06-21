package com.luotao.demo.sc.common.config.spring;


import com.luotao.demo.sc.common.BusinessException;
import com.luotao.demo.sc.common.CommonException;
import com.luotao.demo.sc.common.ExceptionUtils;
import com.luotao.demo.sc.common.response.ResponseCommon;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 17:28
 */
//@Configuration
@ControllerAdvice
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @ExceptionHandler//处理所有异常
    @ResponseBody
    public ResponseCommon defaultErrorHandler(Throwable ex) {
        ExceptionUtils.printException(ex, 10);
        ResponseCommon responseCommon = new ResponseCommon();
        responseCommon.setMessage(ex.getMessage());
        if (ex instanceof BusinessException) {
            BusinessException ex1 = (BusinessException) ex;
            responseCommon.setCode(ex1.getCode());
            return responseCommon;
        } else {
            responseCommon.setCode(CommonException.code_known_error);
            responseCommon.setMessage(ex.getMessage());
            return responseCommon;
        }
    }

    @Bean
    public JsonHttpMessageConverter messageConverter() {
        return new JsonHttpMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(messageConverter());
    }
}
