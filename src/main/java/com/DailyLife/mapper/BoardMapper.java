package com.DailyLife.mapper;

import com.DailyLife.dto.Board;
import com.DailyLife.dto.UserPhoto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface BoardMapper {


    int addBoard(Board bo);

    int addPhoto(UserPhoto userPhoto);

}
