package com.example.nextblog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.nextblog.annotation.ParameterConvert;
import com.example.nextblog.model.dto.UpdateTag;
import com.example.nextblog.model.entity.Tag;
import com.example.nextblog.model.vo.Result;
import com.example.nextblog.service.TagService;
import com.example.nextblog.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    @ResponseBody
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

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Tag tag = tagService.getById(id);
        ModelAndView modelAndView = new ModelAndView("admin/tag/edit");
        modelAndView.addObject("tagName", tag.getTagName());
        modelAndView.addObject("id", tag.getId());
        return modelAndView;
    }

    @PostMapping("update")
    @ResponseBody
    public Result<Object> update(@Validated @ParameterConvert UpdateTag updateTagParam) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(updateTagParam, tag);
        boolean res = tagService.updateById(tag);
        if (res) {
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.fail("修改失败");
    }

    @PostMapping("delete")
    @ResponseBody
    public Result<Object> delete(@RequestParam Long id) {
        if (tagService.removeById(id)) {
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.fail("删除失败");
    }
}
