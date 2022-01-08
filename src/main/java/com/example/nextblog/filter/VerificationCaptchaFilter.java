package com.example.nextblog.filter;

import com.example.nextblog.constant.consist.SessionConstants;
import com.example.nextblog.exceptions.VerificationCaptchaException;
import com.example.nextblog.security.FailHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class VerificationCaptchaFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler failureHandler = new FailHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        if (uri.equals("/admin/login") && method.equalsIgnoreCase("post")) {
            try {
                verificationCaptcha(request);
            } catch (VerificationCaptchaException e) {
                failureHandler.onAuthenticationFailure(request, response, e);
            }
        }
        filterChain.doFilter(request, response);
    }

    private void verificationCaptcha(HttpServletRequest request) throws VerificationCaptchaException {
        String captchaCode = request.getParameter("captcha_code");
        if (captchaCode == null || !captchaCode.equals(request.getSession().getAttribute(SessionConstants.CaptchaKey))) {
            throw new VerificationCaptchaException();
        }
    }
}
