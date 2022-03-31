package com.DailyLife.controller;

import com.DailyLife.mapper.UserMapper;
import com.DailyLife.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/index")
    public String index() { return "index";}

    @GetMapping("/test")
    public String test() {
        return "Write";
    }

    @GetMapping("/test2")
    public String test2() {
        return "index";
    }

    @GetMapping("/test3")
    public String test3() {
        return "directmessage";
    }

}
