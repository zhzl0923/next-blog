package com.example.nextblog.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @GetMapping("/categories")
    public String list() {
        return "blog/categories";
    }

    @GetMapping("/categories/{categoryName}")
    public String detail(@PathVariable String categoryName) {
        return "blog/category_detail";
    }
}
