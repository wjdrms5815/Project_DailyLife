package com.DailyLife.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class AddUserDto {

    private Long userNum;
    //(regexp = "^[a-zA-Z0-9].*$" )
    @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$")
    private String userId;
    //^{8,20}(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_]).*$
    @Pattern(regexp = "^{5,15}(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=_]).*$" )
    private String userName;
    //^{8,20}(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_]).*$
    @Pattern(regexp = "^{8,20}(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_]).*$" )
    private String userPassword;
    @Pattern(regexp = "^{8,20}(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_]).*$" )
    private String userPasswordCheck;
    private String userEmail;
    private Integer emailAuthor;

}
