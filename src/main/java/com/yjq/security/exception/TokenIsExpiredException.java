package com.yjq.security.exception;

/**
 * @ClassName TokenIsExpiredException
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/15 23:41
 * @Version 1.0
 */
public class TokenIsExpiredException extends Exception {
    public TokenIsExpiredException() {
    }

    public TokenIsExpiredException(String message) {
        super(message);
    }

    public TokenIsExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenIsExpiredException(Throwable cause) {
        super(cause);
    }

    public TokenIsExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
