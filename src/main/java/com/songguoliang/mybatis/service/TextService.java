package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.Text;
import com.songguoliang.mybatis.mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TextService {

    @Autowired
    private TextMapper textMapper;


    public List<Text> queryAllText() {
        List<Text> textList = textMapper.queryAllText();
        return textList;
    }


    public Text queryByUuid(Integer uuid) {
        return textMapper.queryByUuid(uuid);
    }
}
