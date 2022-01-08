package com.example.nextblog.exceptions;


import org.springframework.security.core.AuthenticationException;

public class VerificationCaptchaException extends AuthenticationException {
    public VerificationCaptchaException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public VerificationCaptchaException(String msg) {
        super(msg);
    }

    public VerificationCaptchaException() {
        super("验证码错误");
    }
}
