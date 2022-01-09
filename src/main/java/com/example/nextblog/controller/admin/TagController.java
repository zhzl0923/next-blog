package com.example.nextblog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.nextblog.model.entity.Tag;
import com.example.nextblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("admin.TagController")
@RequestMapping("/admin/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("list")
    public ModelAndView list(@RequestParam(name = "page", defaultValue = "1") Long page,
                             @RequestParam(name = "page_size", defaultValue = "15") Long pageSize,
                             @RequestParam(name = "tag_name", defaultValue = "") String tagName) {
        Page<Tag> p = new Page<>(page, pageSize);
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (tagName != null && !tagName.equals("")) {
            queryWrapper.like("tag_name", "%" + tagName + "%");
        }
        Page<Tag> tagPage = tagService.page(p, queryWrapper);
        System.out.println(tagPage);
        ModelAndView modelAndView = new ModelAndView("admin/tag/list");
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageSize", pageSize);
        modelAndView.addObject("tagName", tagName);
        modelAndView.addObject("totalPages", tagPage.getPages());
        modelAndView.addObject("list", tagPage.getRecords());
        System.out.println(tagPage.getRecords());
        return modelAndView;
    }
}
