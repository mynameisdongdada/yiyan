package com.songguoliang.mybatis.mapper;

import com.songguoliang.mybatis.entity.Text;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TextMapper {

    List<Text> queryAllText();

    Text queryByUuid(Integer uuid);

    Text queryTodayUuid(String today);

    List<Text> queryLessUuid(Integer uuid);

    int updateYear(@Param("toyear")String toyear,@Param("uuid")Integer uuid);
}
