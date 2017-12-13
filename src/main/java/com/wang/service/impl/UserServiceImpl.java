package com.wang.service.impl;

import com.wang.base.service.impl.BaseServiceImpl;
import com.wang.dao.UserMapper;
import com.wang.entity.User;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/7.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService{
    @Autowired
    private UserMapper userMapper;
}
