package com.example.nextblog.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArchiveController {

    @GetMapping("/archives")
    public ModelAndView index() {
        return new ModelAndView("index/archives");
    }
}
