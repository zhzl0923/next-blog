package com.example.nextblog.security;

import com.example.nextblog.exceptions.VerificationCaptchaException;
import com.example.nextblog.model.vo.Result;
import com.example.nextblog.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class FailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json");
        Result<Object> result;
        if (exception instanceof VerificationCaptchaException) {
            result = ResponseUtil.fail("验证码错误");
        } else {
            result = ResponseUtil.fail("用户名或密码错误");
        }
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, result);
        outputStream.flush();
        outputStream.close();
    }
}
