package com.DailyLife.controller;

import com.DailyLife.dto.AddUserDto;
import com.DailyLife.service.UserService;
import com.DailyLife.validation.AddUserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    public static final String AUTH_TIME_OUT = "AuthTimeOut";
    private final AddUserValidator addUserValidator;
    private final UserService userService;

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("addUserDto", new AddUserDto());
        return "user/addUserForm";
    }

    @PostMapping("/addUser")
    public String signUp(@Validated @ModelAttribute AddUserDto user , BindingResult bindingResult , Model model ,HttpSession session) {

        System.out.println("user = " + user);
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            System.out.println("fieldError = " + fieldError);
        }

        addUserValidator.validate(user , bindingResult);

        if (session.getAttribute("emailCertification") == null && !bindingResult.hasErrors()) {
            bindingResult.reject("NotEmailCertification" , "이메일 검증이 되지 않았습니다.");
        }

        if (bindingResult.hasErrors()) {
            return "user/addUserForm";
        }

        int result = userService.addUser(user);
        System.out.println("result = " + result);

        return "index";
    }

    @GetMapping("/EmailAuthor")
    @ResponseBody
    public Map<String, String > EmailCheck(@CookieValue(value = AUTH_TIME_OUT , required = false) String authKey ,
                                           String userEmail , HttpServletResponse response,
                                           HttpSession session, Model model){

        log.info("이메일 전송 시작");
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userEmail);
        Map<String , String > msg = new HashMap<>();

        if(!matcher.matches()){
            msg.put("key" , "fail");
            msg.put("msg" , "이메일 양식을 확인해주세요.");
            return msg;
        }

        /*
        Cookie 값 찾기
         */
//        Cookie cookie1 = Arrays.stream(request.getCookies()).
//                filter(cookie -> cookie.getName().equals(AUTH_TIME_OUT)).
//                findAny().orElse(null);

        if(matcher.matches() && authKey == null) {
            authKey = userService.emailSend(userEmail);
            System.out.println("authKey = " + authKey);
            session.setAttribute("authKey" , authKey);

            Cookie cookie = new Cookie(AUTH_TIME_OUT, authKey);
            cookie.setMaxAge(60);
            response.addCookie(cookie);

            msg.put("key" , "succese");
            msg.put("msg" , "메일이 전송되었습니다");
            return msg;
        }

        if(authKey != null) {
            msg.put("key" , "emailDuplicate");
            msg.put("msg" , "60초후에 다시 전송해주세요.");
            return msg;
        }

        return null;
    }

    @PostMapping("/emailAuthorCheck")
    @ResponseBody
    public Map<String, String > AuthorCheck(String emailAuthor , HttpSession session) {

        String authKey = (String)session.getAttribute("authKey");
        Map<String , String > msg = new HashMap<>();

        if(emailAuthor.equals(authKey)) {
            msg.put("key" , "success");
            msg.put("msg" , "확인되었습니다.");
            session.removeAttribute("authKey");
            session.setAttribute("emailCertification" , msg);
            return msg;
        }
        else {
            msg.put("key" , "fail");
            msg.put("msg" , "일치하지 않습니다.");
        }
        return msg;
    }


}
