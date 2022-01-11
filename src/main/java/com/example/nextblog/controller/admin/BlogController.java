package com.example.nextblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("admin.BlogController")
public class BlogController {

    @GetMapping(value = {"/admin/blog/edit", "/admin/blog/edit/{id}"})
    public String edit(@PathVariable(name = "id", required = false) Integer articleID) {
        return "admin/blog/edit";
    }
}
