package com.aididi.exception;

/**
 * @Auther: Administrator
 * @Date: 2018/4/20 0020 09:32
 * @Description:
 */
public class MyRunException extends RuntimeException {

    public MyRunException() {
    }

    public MyRunException(String message) {
        super(message);
    }

    public MyRunException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRunException(Throwable cause) {
        super(cause);
    }

    public MyRunException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
