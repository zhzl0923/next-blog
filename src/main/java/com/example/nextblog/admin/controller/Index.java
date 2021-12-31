package com.example.nextblog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping("/admin")
    public String index() {
        return "admin/index";
    }
}
