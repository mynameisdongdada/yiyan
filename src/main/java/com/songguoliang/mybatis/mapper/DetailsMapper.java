package com.songguoliang.mybatis.mapper;

import com.songguoliang.mybatis.entity.Details;

import java.util.List;

public interface DetailsMapper {

    List<Details> queryDetailsByType();

    List<Details> queryDetailsByChangWen();


    List<Details> queryDetailsByMusic();
}
