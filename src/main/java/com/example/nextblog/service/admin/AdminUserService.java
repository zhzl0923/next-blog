package com.example.nextblog.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nextblog.mapper.AdminUserMapper;
import com.example.nextblog.model.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("AdminUserService")
public class AdminUserService implements UserDetailsService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return adminUserMapper.selectOne(queryWrapper);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAdminUserByUsername(username);
    }
}
