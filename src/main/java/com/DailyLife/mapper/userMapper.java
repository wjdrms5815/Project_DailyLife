package com.DailyLife.mapper;

import com.DailyLife.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface userMapper {

    List <User> findAll();

}