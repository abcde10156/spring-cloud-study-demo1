package com.luotao.demo.sc.service.res;

import com.luotao.demo.sc.BusiException;
import com.luotao.demo.sc.ExceptionUtils;
import com.luotao.demo.sc.ResponseCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
    public ResponseCommon defaultErrorHandler(Object object, Throwable ex) {
//        Span currentSpan = tracer.getCurrentSpan();
//        currentSpan.logEvent(Span.SPAN_ERROR_TAG_NAME);
        ExceptionUtils.printException(ex, 10);
//        addChildSpan(currentSpan,ex, 10);
        ResponseCommon fail;
        if (ex instanceof BusiException) {
            BusiException busiException = (BusiException) ex;
            fail = ResponseCommon.fail(busiException.getCode(), "", busiException.getMessage(), ex);
        } else {
            fail = ResponseCommon.fail(99999, "", ex.getMessage(), ex);
        }
        return fail;
    }


//    public void addChildSpan(Span currentSpan,Throwable e, int show_error_count) {
//        StackTraceElement[] stackTraceElements = e.getStackTrace();
//        StringBuilder stringBuilder = new StringBuilder();
//        if (show_error_count > 0) {
//            for (int i = 0; i < show_error_count && i < stackTraceElements.length; i++) {
//                stringBuilder.append(stackTraceElements[i].toString()).append("\n");
//            }
//            Span newSpan = tracer.createSpan(e.getMessage());
//            currentSpan.tag("error_info", stringBuilder.toString());
//            currentSpan.tag("Local Component", "service-res");
//            currentSpan.logEvent(Span.SPAN_ERROR_TAG_NAME);
////            tracer.close(newSpan);
//        }
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
                System.out.println("modelAndView = " + modelAndView);
            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
                System.out.println("httpServletRequest = " + httpServletRequest);
            }
        });
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
