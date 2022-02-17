package com.DailyLife.controller;

import com.DailyLife.mapper.userMapper;
import com.DailyLife.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.DailyLife.mapper.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class testController {

    private final userMapper userMapper;

    @GetMapping("/")
    @ResponseBody
    public String mybatisTest() {

        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            System.out.println("user = " + user);
        }

        return "OK";

    }

    @GetMapping("/test")
    public String staticResourceTest() {

        return "addUser";

    }

    @GetMapping("/test2")
    public String staticResourceTest2() {
        return "directmessage";
    }

}
