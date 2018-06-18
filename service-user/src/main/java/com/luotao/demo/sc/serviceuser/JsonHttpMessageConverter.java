package com.luotao.demo.sc.serviceuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luotao.demo.sc.IResponse;
import com.luotao.demo.sc.ResponseCommon;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 17:30
 */
public class JsonHttpMessageConverter extends AbstractHttpMessageConverter {

    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    public JsonHttpMessageConverter() {
        super(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

//    @Override
//    public boolean canWrite(Class clazz, MediaType mediaType) {
//        return true;
//    }

    @Override
    protected boolean supports(Class aClass) {
        return true;
    }

    @Override
    protected IResponse readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("aClass = " + aClass);
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (o instanceof IResponse) {
            IResponse iResponse = (IResponse) o;
            ResponseCommon fail = ResponseCommon.fail(iResponse.getCode(),"", iResponse.getMessage(), null);
            byte[] s = objectMapper.writeValueAsBytes(fail);
            httpOutputMessage.getBody().write(s);
        } else {
            ResponseCommon ok = ResponseCommon.success(0, "ok", o);
            byte[] s = objectMapper.writeValueAsBytes(ok);
            httpOutputMessage.getBody().write(s);
        }


    }
}
