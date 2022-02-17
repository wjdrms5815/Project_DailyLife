package com.DailyLife.user;

import lombok.Data;

@Data
public class User {

    private Long userId;
    private String userName;
    private String userPassword;
    private String userEmail;

}
