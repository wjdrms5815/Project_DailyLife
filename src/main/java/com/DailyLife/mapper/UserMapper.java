package com.DailyLife.mapper;

import com.DailyLife.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List <User> findAll();

    int addUser(User user);

    int login(User user);
}
