package com.example.nextblog.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nextblog.mapper.AdminUserMapper;
import com.example.nextblog.model.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        AdminUser adminUser = adminUserMapper.selectOne(queryWrapper);
        if (adminUser.getId() > 0) {
            List<GrantedAuthority> list = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + adminUser.getId());
            list.add(authority);
            user = new User(adminUser.getUsername(), adminUser.getPassword(), list);
        }
        return user;
    }
}
