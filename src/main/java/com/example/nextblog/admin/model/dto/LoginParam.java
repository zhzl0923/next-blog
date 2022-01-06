package com.example.nextblog.admin.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginParam implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @JsonProperty(value = "captcha_code")
    private String captchaCode;

}
