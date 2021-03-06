package com.example.nextblog.security;

import com.example.nextblog.constant.consist.SessionConstants;
import com.example.nextblog.model.entity.AdminUser;
import com.example.nextblog.model.vo.Result;
import com.example.nextblog.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        AdminUser adminUser = (AdminUser) authentication.getPrincipal();
        session.setAttribute(SessionConstants.AUTHOR_IMG, adminUser.getAvatar());
        session.setAttribute(SessionConstants.LOGIN_USER, adminUser.getNickName());
        session.setAttribute(SessionConstants.LOGIN_USER_ID, adminUser.getId());
        session.setAttribute(SessionConstants.LOGIN_USER_NAME, adminUser.getUsername());
        response.setContentType("application/json");
        Result<Object> result = ResponseUtil.success("登录成功");
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, result);
        outputStream.flush();
        outputStream.close();
    }
}
