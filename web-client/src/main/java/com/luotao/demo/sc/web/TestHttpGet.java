package com.luotao.demo.sc.web;

import com.luotao.demo.sc.common.HttpUtils;
import com.luotao.demo.sc.common.TesterConcurrent;

/**
 * @author luotao-work
 *         date   2018-06-21 17:35
 */
public class TestHttpGet {
    public static void main(String[] args) throws Exception {

        final String url = "http://127.0.0.1:3001/ribbon-consumer?id=100";

        TesterConcurrent.runLoopInner(10, new TesterConcurrent.ITestable() {
            @Override
            public void execute(long index, long threadid, int loop_index) throws Exception {
                byte[] bytes = HttpUtils.doGet(url);
                String result = new String(bytes,"UTF-8");
                System.out.println("result = " + result);
            }
        }, 10);
    }
}
