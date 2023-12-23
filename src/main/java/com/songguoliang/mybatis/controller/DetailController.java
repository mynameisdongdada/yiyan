package com.songguoliang.mybatis.controller;

import com.songguoliang.mybatis.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DetailController {

    @Autowired
    private DetailsService detailsService;


    @RequestMapping("/queryMain")
    @ResponseBody
    public Map<String, Object> queryMain() {
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("details",detailsService.queryDetailsByMain());
        return  resultMap;
    }
}
