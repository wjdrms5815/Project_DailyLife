package com.DailyLife.controller;

import com.DailyLife.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String main(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "main";
        }

        User user = (User)session.getAttribute("user");
        model.addAttribute("user" , user);
        return "index";
    }

//    @GetMapping("/index")
//    public String index() { return "index";}


}
