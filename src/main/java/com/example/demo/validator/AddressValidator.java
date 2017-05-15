package com.example.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.entity.Address;

public class AddressValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO: to be implemented.
    }
}
