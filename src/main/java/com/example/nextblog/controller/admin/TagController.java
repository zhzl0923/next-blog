package com.example.nextblog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.nextblog.model.entity.Tag;
import com.example.nextblog.model.vo.Result;
import com.example.nextblog.service.TagService;
import com.example.nextblog.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        ModelAndView modelAndView = new ModelAndView("admin/tag/list");
        modelAndView.addObject("page", page);
        modelAndView.addObject("pageSize", pageSize);
        modelAndView.addObject("tagName", tagName);
        modelAndView.addObject("totalPages", tagPage.getPages());
        modelAndView.addObject("list", tagPage.getRecords());
        return modelAndView;
    }

    @GetMapping("add")
    public String add() {
        return "admin/tag/add";
    }

    @PostMapping("create")
    public Result<Object> create(@RequestParam(name = "tag_name") String tagName) {
        if (tagName.equals("")) {
            return ResponseUtil.fail("请输入标签名称");
        }
        Tag tag = new Tag();
        tag.setTagName(tagName);
        if (tagService.save(tag)) {
            return ResponseUtil.success("添加成功");
        } else {
            return ResponseUtil.fail("添加失败");
        }
    }

}
