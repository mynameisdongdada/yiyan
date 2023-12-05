package com.songguoliang.mybatis.controller;

import com.songguoliang.mybatis.entity.Details;
import com.songguoliang.mybatis.entity.Text;
import com.songguoliang.mybatis.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/queryLastNew")
    @ResponseBody
    public Map<String, Object> queryLastNew() {
        return  homeService.queryLastNew();
    }


    @RequestMapping("/queryByOne")
    @ResponseBody
    public Map<String, Object> queryByOne(Integer uuid) {
        return  homeService.queryByOne(uuid);
    }

}
