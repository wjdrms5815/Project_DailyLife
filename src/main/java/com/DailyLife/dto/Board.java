package com.DailyLife.dto;


import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
@Data
@Mapper
public class Board {
    private long bno;
    private String boardPhoto;
    private String boardContent;
    private String userId;
    private java.util.Date Date;
}