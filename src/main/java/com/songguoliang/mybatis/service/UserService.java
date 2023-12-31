package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.User;
import com.songguoliang.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:01
 */
@Transactional(readOnly =false)
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }
    public Integer queryAge(Integer id){
        return userMapper.queryAge(id);
    }
}
