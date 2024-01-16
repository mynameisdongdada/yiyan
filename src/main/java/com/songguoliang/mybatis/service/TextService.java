package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.Text;
import com.songguoliang.mybatis.mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public Map<String,Object> queryTodayText(){
        Map<String,Object> resultMap=new HashMap<>();
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 创建一个不含年份的日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        // 使用格式化器格式化日期
        String todayStr = today.format(formatter);
        System.out.println("今日日期:"+todayStr);
        Text text = textMapper.queryTodayUuid(todayStr);
        List<Text> texts=new ArrayList<>();
        if (!ObjectUtils.isEmpty(text)){
            resultMap.put("text", text);
            if("12-07".equals(todayStr)){
                texts = textMapper.queryLessUuid(365);
            }else{
                texts = textMapper.queryLessUuid(text.getUuid());
            }
            resultMap.put("testList", texts);
        }else{
            texts = textMapper.queryAllText();
            Text text1 = texts.get(0);
            resultMap.put("text", text1);
            if (texts.size() > 1) {
                texts.remove(0);
                resultMap.put("testList", texts);
            }
        }
        return resultMap;
    }
}
