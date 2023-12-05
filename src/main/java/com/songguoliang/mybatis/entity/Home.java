package com.songguoliang.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Home implements Serializable {
    private Integer uuid;

    private String  today;

    private String  image;

    private String  audio;

    private String  video;
}
