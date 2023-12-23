package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.Details;
import com.songguoliang.mybatis.mapper.DetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetailsService {

    @Autowired
    private DetailsMapper detailsMapper;


    public List<Details> queryDetailsByType() {
        return detailsMapper.queryDetailsByType();
    }


    public Map<String,Object> queryDetailsByChangWenMusic() {
        List<Details> changwenList = detailsMapper.queryDetailsByChangWen();
        List<Details> musicList = detailsMapper.queryDetailsByMusic();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("changWen",changwenList.get(0));
        resultMap.put("music",musicList.get(0));
        return resultMap;
    }


    public String queryMusicFlag(){
        return detailsMapper.queryDetailsByMusicFlag();
    }

    public List<Details> queryDetailsByMain() {
        return detailsMapper.queryDetailsByMain();
    }
}
