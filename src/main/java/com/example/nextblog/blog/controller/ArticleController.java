package com.example.nextblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {
    @GetMapping("/article/detail/{id}")
    public String detail(@PathVariable long id) {
        return "blog/detail";
    }
}
