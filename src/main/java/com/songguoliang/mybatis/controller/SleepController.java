package com.songguoliang.mybatis.controller;


import com.songguoliang.mybatis.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SleepController {


    @Autowired
    private SleepService sleepService;


    @RequestMapping("/queryByUuidOfSleep")
    @ResponseBody
    public Map<String, Object> queryByUuidOfSleep(Integer uuid) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("video", sleepService.queryByOne(uuid));
        return resultMap;
    }
}
