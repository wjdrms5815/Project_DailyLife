package com.DailyLife.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
