package com.DailyLife.service;

import com.DailyLife.dto.User;
import com.DailyLife.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService{

    private final JavaMailSender mailSender;
    private final UserMapper userMapper;
    private static long sequence = 0L;

    public String emailSend(String userEmail) {
        Random rd = new Random();

        StringBuilder authKey = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            authKey.append(rd.nextInt(10));
        }

        System.out.println("userEmail = " + userEmail);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("인증메일입니다.");
        message.setText(authKey.toString());

//        mailSender.send(message);
        return authKey.toString();
    }

    public int addUser(User user) {
        user.setUserNum(++sequence);
       return userMapper.addUser(user);
    }

    public int login(User user){
        return userMapper.login(user);
    }

}
