package com.example.nextblog.model.dto;

import lombok.Data;

@Data
public class LoginCaptcha {
    private String key;
    private String image;
}
