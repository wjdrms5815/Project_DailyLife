package com.DailyLife.mapper;

import com.DailyLife.dto.AddUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List <AddUserDto> findAll();

    int addUser(AddUserDto addUserDto);

}
