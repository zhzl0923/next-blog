package com.example.nextblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.nextblog.model.entity.AdminUser;

public interface AdminUserService extends IService<AdminUser> {
    public AdminUser getAdminUserByUsername(String username);
}
