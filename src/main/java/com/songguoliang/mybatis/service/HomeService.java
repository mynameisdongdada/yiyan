package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.Home;
import com.songguoliang.mybatis.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeService {

    @Autowired
    private HomeMapper homeMapper;


    public Map<String,Object> queryLastNew(){
        Home home = homeMapper.queryLastNew();
        Map<String,Object> resultHome=new HashMap<>();
        resultHome.put("home",home);
        return resultHome;
    }

    public Map<String,Object> queryByOne(Integer uuid){
        Home home = homeMapper.queryOneByUuid(uuid);
        Map<String,Object> resultHome=new HashMap<>();
        resultHome.put("home",home);
        return resultHome;
    }

}
