package com.example.nextblog.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String index() {
        return "blog/about";
    }
}
