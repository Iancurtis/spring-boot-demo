package com.example.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.entity.User;

public class UserValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

  	public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        User user = (User) target;
        if (user.getAge() < 0) {
            errors.rejectValue("age", "negativevalue");
        } else if (user.getAge() > 10) {
            errors.rejectValue("age", "too.darn.old");
        }
    }
 
}