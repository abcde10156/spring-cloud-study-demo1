package com.luotao.demo.sc.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * User: luotao-pc
 * Date: 2018/6/15
 * Time: 16:17
 */

@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinApplication {

  public static void main(String[] args) {
  	SpringApplication.run(ZipkinApplication.class, args);
  }

}
