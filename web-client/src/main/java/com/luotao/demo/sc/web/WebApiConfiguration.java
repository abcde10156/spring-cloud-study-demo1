package com.luotao.demo.sc.web;

import com.luotao.demo.sc.ResponseCommon;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.web.TraceFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
@EnableFeignClients
public class WebApiConfiguration extends WebMvcConfigurerAdapter {


    @Bean
    TraceFilter myTraceFilter(BeanFactory beanFactory, final Tracer tracer) {
        return new TraceFilter(beanFactory) {
            @Override
            protected void addResponseTags(HttpServletResponse response,
                                           Throwable e) {
                // execute the default behaviour
                // for readability we're returning trace id in a hex form
                response.addHeader("ZIPKIN-TRACE-ID",
                        Span.idToHex(tracer.getCurrentSpan().getTraceId()));
                super.addResponseTags(response, e);

                // we can also add some custom tags
//    			tracer.addTag("custom", "tag");
            }
        };
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

    @Autowired
    Tracer tracer;

    @ExceptionHandler//处理所有异常
    @ResponseBody
    public ResponseCommon defaultErrorHandler(HttpServletRequest req, Throwable ex) {
        Span currentSpan = tracer.getCurrentSpan();
        currentSpan.logEvent(Span.SPAN_ERROR_TAG_NAME);

//        currentSpan.getTraceId();
        return ResponseCommon.fail(99998, "", ex.getMessage(), new RuntimeException("超时"));
    }

}
