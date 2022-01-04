package com.example.nextblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TagController {

    @GetMapping("/tags")
    public String list() {
        return "blog/tags";
    }

    @GetMapping("/tags/{tagName}")
    public String detail(@PathVariable String tagName) {
        return "blog/tag_detail";
    }
}
