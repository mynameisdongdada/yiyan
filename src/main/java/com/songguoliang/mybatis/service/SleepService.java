package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.Home;
import com.songguoliang.mybatis.entity.Sleep;
import com.songguoliang.mybatis.mapper.SleepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SleepService {

    @Autowired
    private SleepMapper sleepMapper;


    public Map<String,Object> queryByOne(Integer uuid){
        Sleep sleep = sleepMapper.queryByUuid(uuid);
        Map<String,Object> resultSleep=new HashMap<>();
        resultSleep.put("sleep",sleep);
        return resultSleep;
    }
}
