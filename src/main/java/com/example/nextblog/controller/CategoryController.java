package com.example.nextblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @GetMapping("/categories")
    public ModelAndView list() {
        return new ModelAndView("categories");
    }

    @GetMapping("/categories/{categoryName}")
    public ModelAndView detail(@PathVariable String categoryName) {
        return new ModelAndView("category_detail");
    }
}
