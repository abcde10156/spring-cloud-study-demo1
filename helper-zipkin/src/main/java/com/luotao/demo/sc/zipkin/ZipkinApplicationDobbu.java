package com.luotao.demo.sc.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

import java.util.Arrays;
import java.util.List;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 16:17
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplicationDobbu {

    public static void main(String[] args) {
        String[] newargs = new String[args.length + 2];

        for (int i = 0; i < args.length; i++) {
            newargs[i] = args[i];
        }
        newargs[newargs.length - 2] = "--server.port=11009";
        newargs[newargs.length - 1] = "--zipkin.storage.elasticsearch.hosts=127.0.0.1:9600";
        SpringApplication.run(ZipkinApplicationDobbu.class, newargs);
    }

}
