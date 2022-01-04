package com.example.nextblog.admin.model.dto;


import javax.validation.constraints.NotNull;

public class LoginParam {

    @NotNull
    private String username;

    @NotNull
    private String password;


}
