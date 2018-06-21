package com.luotao.demo.sc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: luotao
 * Date: 12-4-19
 * Time: 12:42:00
 */
public class TesterConcurrent {
    public static long runTask(int thread_num, final ITestable iTestable, final int loop_count, final boolean loopInner) {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(thread_num);

        final ExecutorService exec = Executors.newFixedThreadPool(thread_num);
        for (int index = 0; index < thread_num; index++) {
            final int ii = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        begin.await();
                        if (loopInner) {
                            for (int i = 0; i < loop_count; i++) {
                                //   System.out.println("Thread.currentThread().getId() = " + Thread.currentThread().getId());
                                try {
                                    iTestable.execute(ii, Thread.currentThread().getId(), i);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                iTestable.execute(ii, Thread.currentThread().getId(), loop_count);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (InterruptedException e) {
                    } finally {
                        end.countDown();
                    }
                }
            };
            exec.submit(run);
        }
        long start = System.currentTimeMillis();
        begin.countDown();
        try {
            end.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(TesterConcurrent.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
        long endtime = System.currentTimeMillis();
        exec.shutdown();
        return endtime - start;
    }

    public static long runLoopInner(int thread_num, final ITestable iTestable, final int loop_count) {
        return runTask(thread_num, iTestable, loop_count, true);
    }

    public static long runTaskSubClass(int thread_num, final ITestable iTestable, final int loop_count) {
        return runTask(thread_num, iTestable, loop_count, false);
    }

    /**
     * @author luotao
     */
    public static interface ITestable {
        public void execute(long index, long threadid, int loop_index) throws Exception;
    }
}
