package com.songguoliang.mybatis.service;

import com.songguoliang.mybatis.entity.Text;
import com.songguoliang.mybatis.mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        List<Text> texts=new LinkedList<>();
        if (!ObjectUtils.isEmpty(text)){
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy");
            String year = today.format(formatter1);
           if(year.equals(text.getToyear())){
               resultMap.put("text", text);
           }else{
               text.setToyear(year);
               textMapper.updateYear(year,text.getUuid());
               resultMap.put("text", text);
           }
            if("12-07".equals(todayStr)){
                texts = textMapper.queryLessUuid(369);
            }else if("12-08".equals(todayStr)){
                Text text1 = textMapper.queryByUuid(1);
                texts.add(text1);
                texts.addAll(textMapper.queryLessUuid(369));
            }else if("12-09".equals(todayStr)){
                Text text1 = textMapper.queryByUuid(1);
                Text text2 = textMapper.queryByUuid(2);
                texts.add(text2);
                texts.add(text1);
                texts.addAll(textMapper.queryLessUuid(369));
            }else if("12-10".equals(todayStr)){
                Text text1 = textMapper.queryByUuid(1);
                Text text2 = textMapper.queryByUuid(2);
                Text text3 = textMapper.queryByUuid(3);
                texts.add(text3);
                texts.add(text2);
                texts.add(text1);
                texts.addAll(textMapper.queryLessUuid(369));
            }else if("12-11".equals(todayStr)){
                Text text1 = textMapper.queryByUuid(1);
                Text text2 = textMapper.queryByUuid(2);
                Text text3 = textMapper.queryByUuid(3);
                Text text4 = textMapper.queryByUuid(4);
                texts.add(text4);
                texts.add(text3);
                texts.add(text2);
                texts.add(text1);
                texts.addAll(textMapper.queryLessUuid(369));
            }else{
                texts = textMapper.queryLessUuid(text.getUuid());
            }
            if(!CollectionUtils.isEmpty(texts)){
                /*int size=texts.size();
                links.add(texts.get(size-2).getChunbj());
                links.add(texts.get(size-1).getChunbj());
                links.add(text.getChunbj());
                resultMap.put("details",links);*/
                resultMap.put("testList", texts);
            }
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
