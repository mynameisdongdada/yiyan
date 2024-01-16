package com.songguoliang.mybatis.mapper;

import com.songguoliang.mybatis.entity.Text;

import java.util.List;

public interface TextMapper {

    List<Text> queryAllText();

    Text queryByUuid(Integer uuid);

    Text queryTodayUuid(String today);

    List<Text> queryLessUuid(Integer uuid);
}
