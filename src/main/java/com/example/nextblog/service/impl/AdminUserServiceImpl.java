package com.example.nextblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.nextblog.mapper.AdminUserMapper;
import com.example.nextblog.model.entity.AdminUser;
import com.example.nextblog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser>
        implements AdminUserService, UserDetailsService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return adminUserMapper.selectOne(queryWrapper);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return getOne(queryWrapper, false);
    }
}
