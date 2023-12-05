package com.songguoliang.mybatis.mapper;

import com.songguoliang.mybatis.entity.Home;

public interface HomeMapper {

    Home queryLastNew();

    Home queryOneByUuid(Integer uuid);
}
