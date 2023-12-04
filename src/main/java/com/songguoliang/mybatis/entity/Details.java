package com.songguoliang.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Details implements Serializable {

    private Integer id;

    private String  flag;

    private String  type;

    private String  link;

}
