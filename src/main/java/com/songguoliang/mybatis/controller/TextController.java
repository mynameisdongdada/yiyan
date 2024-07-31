package com.songguoliang.mybatis.controller;

import com.songguoliang.mybatis.entity.Details;
import com.songguoliang.mybatis.entity.Text;
import com.songguoliang.mybatis.service.DetailsService;
import com.songguoliang.mybatis.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TextController {

    @Autowired
    private TextService textService;

    @Autowired
    private DetailsService detailsService;

    @RequestMapping("/queryAllText")
    @ResponseBody
    public Map<String, Object> queryAllText() {
        Map<String, Object> resultMap = new HashMap<>();
        String audioFlag = detailsService.queryMusicFlag();
        if(!"1".equals(audioFlag)){
            return resultMap;
        }
        List<Text> texts = textService.queryAllText();
        if(!CollectionUtils.isEmpty(texts)){
            Text text = texts.get(0);
            resultMap.put("text", text);
            if (texts.size() > 1) {
                texts.remove(0);
                resultMap.put("testList", texts);
            }
        }
        List<Details> details = detailsService.queryDetailsByType();
        resultMap.put("details", details);
        String top = detailsService.queryDetailsByTop();
        resultMap.put("top", top);
        return resultMap;
    }

    @RequestMapping("/queryAllTextNew")
    @ResponseBody
    public Map<String, Object> queryAllTextNew() {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> stringObjectMap = textService.queryTodayText();
        resultMap.putAll(stringObjectMap);
        return resultMap;
    }


    @RequestMapping("/queryByUuid")
    @ResponseBody
    public Map<String, Object> queryByUuid(Integer uuid) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("text", textService.queryByUuid(uuid));
        resultMap.put("flag",detailsService.queryMusicFlag());//查询是否能够显示音乐标志
        return resultMap;
    }


    @RequestMapping("/queryDetailsByChangWenMusic")
    @ResponseBody
    public Map<String, Object> queryDetailsByChangWenMusic() {
        return detailsService.queryDetailsByChangWenMusic();
    }


    @RequestMapping("/isAudioFlag")
    @ResponseBody
    public Map<String, Object> isAudioFlag() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("flag",detailsService.queryMusicFlag());//查询是否能够显示音乐标志
        return resultMap;
    }
}
