package com.songguoliang.mybatis.mapper;

import com.songguoliang.mybatis.entity.Sleep;
import org.springframework.stereotype.Service;

@Service
public interface SleepMapper {

    Sleep queryByUuid(Integer uuid);

}
