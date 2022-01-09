package com.example.nextblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nextblog.model.entity.Tag;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface TagMapper extends BaseMapper<Tag> {
}
