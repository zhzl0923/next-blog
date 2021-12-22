package com.example.nextblog.admin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    public String index() {
        return "hello";
    }
}
