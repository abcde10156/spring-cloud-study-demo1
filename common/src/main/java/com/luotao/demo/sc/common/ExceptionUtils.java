package com.luotao.demo.sc.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: luotao
 * Date: 13-10-22
 * Time: 15:40
 */
public class ExceptionUtils {

    protected static Logger logger = LoggerFactory.getLogger(ExceptionUtils.class);

    public static void printException(Throwable throwable) {
        printException(throwable, -1);
    }

    public static void printException10(Throwable throwable) {
        printException(throwable);
    }

    public static void printException(Throwable throwable, int errorStackDeep) {
        logger.error(throwable.toString());
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        if (errorStackDeep == -1) {
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                logger.error(stackTraceElement.toString());
            }
        } else if (errorStackDeep > 0) {
            for (int i = 0; i < errorStackDeep && i < stackTraceElements.length; i++) {
                logger.error(stackTraceElements[i].toString());
            }
        }

    }

    public static void throwEx(String errMsg) {
        RuntimeException exception = new RuntimeException(errMsg);
        ExceptionUtils.printException(exception);
        throw exception;
    }

    public static void throwEx(RuntimeException e) {
        ExceptionUtils.printException(e);
        throw e;
    }

    public static RuntimeException makeException(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e.getMessage());
        }
    }
}
