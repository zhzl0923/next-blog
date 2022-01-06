package com.example.nextblog.admin.controller;

import com.example.nextblog.admin.model.dto.LoginCaptcha;
import com.example.nextblog.admin.model.dto.LoginParam;
import com.example.nextblog.admin.model.dto.Result;
import com.example.nextblog.annotation.ParameterConvert;
import com.example.nextblog.constant.consist.SessionConstants;
import com.example.nextblog.utils.ImageCaptchaUtil;
import com.example.nextblog.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/admin/captcha")
    @ResponseBody
    public Result<LoginCaptcha> captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCaptchaUtil captchaUtils = new ImageCaptchaUtil();
        BufferedImage image = captchaUtils.getImage();  //获取验证码
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        captchaUtils.output(image, stream);
        String imageData = Base64.getEncoder().encodeToString(stream.toByteArray());

        LoginCaptcha captcha = new LoginCaptcha();
        captcha.setKey(SessionConstants.CaptchaKey);

        request.getSession().setAttribute(captcha.getKey(), captchaUtils.getText()); //将验证码的文本存在session中
        captcha.setImage("data:image/jpg;base64," + imageData);
        return ResponseUtil.success(captcha, "获取成功");
    }

    @PostMapping("/admin/login")
    @ResponseBody
    public Result<Object> login(@ParameterConvert LoginParam loginRequest, HttpServletRequest request) {
        if (!loginRequest.getCaptchaCode().equals(request.getSession().getAttribute(SessionConstants.CaptchaKey))) {
            return ResponseUtil.fail(null, "验证码错误");
        }
        request.getSession().removeAttribute(SessionConstants.CaptchaKey);
        return ResponseUtil.success(null,"登录成功");
    }

}
