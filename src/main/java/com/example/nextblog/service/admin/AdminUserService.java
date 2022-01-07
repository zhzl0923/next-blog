package com.example.nextblog.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nextblog.mapper.AdminUserMapper;
import com.example.nextblog.model.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService  {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return adminUserMapper.selectOne(queryWrapper);
    }
}
