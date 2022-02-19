package com.DailyLife.validation;

import com.DailyLife.dto.AddUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class AddUserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AddUserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddUserDto addUser = (AddUserDto) target;

        BindingResult error = (BindingResult) errors;

        //hasText(adduser.emailAuthor) <- 값이 있나요 ?
        //emailAuthor == null <- 값이 없다.
        //emailAuthor != null <- 값이 있다(타입은 안맞음)
        //전체중에 하나라도 있으면 비어있으면

        FieldError emailAuthor = error.getFieldError("emailAuthor");

        if(!(hasText(addUser.getUserPassword()) && hasText(addUser.getUserPasswordCheck()) &&
                hasText(addUser.getUserEmail()) && hasText(addUser.getUserId())
                && hasText(addUser.getUserName()) ))
        {
            errors.reject("NotEmpty" ,"모두 입력해주세요.");
        } else if(!addUser.getUserPassword().equals(addUser.getUserPasswordCheck())) {
            errors.reject("PwDuplicated" ,"비밀번호는 같아야 합니다.");
        }
    }
}
