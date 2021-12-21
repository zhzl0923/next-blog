package com.example.nextblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TagController {

    @GetMapping("/tags")
    public ModelAndView list() {
        return new ModelAndView("tags");
    }

    @GetMapping("/tags/{tagName}")
    public ModelAndView detail(@PathVariable String tagName) {
        return new ModelAndView("tag_detail");
    }
}
