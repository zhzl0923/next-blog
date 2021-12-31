package com.example.nextblog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleManager {

    @GetMapping(value = {"/admin/article/edit", "/admin/article/edit/{id}"})
    public String edit(@PathVariable(name = "id", required = false) Integer articleID) {
        return "admin/article/edit";
    }
}
