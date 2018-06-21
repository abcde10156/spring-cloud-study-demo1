package com.luotao.demo.sc.serviceuser;

import com.luotao.demo.sc.BusiException;
import com.luotao.demo.sc.IResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 17:28
 */
@Configuration
@ControllerAdvice
public class WebApiConfiguration extends WebMvcConfigurerAdapter {

//    @Autowired
//    Tracer tracer;

    @ExceptionHandler//处理所有异常
    @ResponseBody
    public IResponse defaultErrorHandler(HttpServletRequest req, Throwable ex) {
//        Span currentSpan = tracer.getCurrentSpan();
//        currentSpan.logEvent(Span.SPAN_ERROR_TAG_NAME);
        return new BusiException(9990, ex);
    }

    @Bean
    public JsonHttpMessageConverter messageConverter() {
        return new JsonHttpMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            System.out.println("converter.getClass().getName() = " + converter.getClass().getName());
        }
        converters.add(messageConverter());
    }
}
