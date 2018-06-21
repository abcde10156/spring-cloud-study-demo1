package com.luotao.demo.sc.common.config.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luotao.demo.sc.common.response.ResponseCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 17:30
 */
public class JsonHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    static final Logger logger = LoggerFactory.getLogger(JsonHttpMessageConverter.class);


    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        super.writeInternal(object, type, outputMessage);

        if (object instanceof ResponseCommon) {
            logger.info("o:" + new ObjectMapper().writeValueAsString(object));
        }


//        Object o;
//        if (object instanceof RequestCommon) {
//            o = object;
//            super.writeInternal(object, type, outputMessage);
//            logger.info("o:" + new ObjectMapper().writeValueAsString(o));
//        } else if (object instanceof ResponseCommon) {
//            ResponseCommon responseCommon = (ResponseCommon) object;
//            super.writeInternal(object, type, outputMessage);
//            logger.info("o:" + new ObjectMapper().writeValueAsString(responseCommon));
//        } else {
////            ResponseCommon<Object> responseCommon = new ResponseCommon<>();
////            responseCommon.setData(object);
////            super.writeInternal(responseCommon, type, outputMessage);
//        }
////        logger.info("o:" + new ObjectMapper().writeValueAsString(o));

    }

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Object value = super.read(type, contextClass, inputMessage);
        logger.info("i:" + new ObjectMapper().writeValueAsString(value));
        return value;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Object o = super.readInternal(clazz, inputMessage);
        System.out.println("o = " + o);
        return o;
    }
}
