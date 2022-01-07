package com.example.nextblog.interceptor;

import com.example.nextblog.constant.consist.SessionConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.regex.Pattern;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    private static final Pattern pattern = Pattern.compile("\\b/admin\\b");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if (!pattern.matcher(uri).find() &&
                Objects.isNull(request.getSession().getAttribute(SessionConstants.LOGIN_USER_ID))) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        } else {
            return true;
        }
    }
}
