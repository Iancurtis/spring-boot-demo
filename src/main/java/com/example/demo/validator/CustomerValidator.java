package com.example.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;

public class CustomerValidator implements Validator {
    
    private final AddressValidator addressValidator;

    public CustomerValidator(AddressValidator addressValidator) {
        if (addressValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is required and must not be null");
        }
        if (!addressValidator.supports(Address.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Adress] instance");
        }
        this.addressValidator = addressValidator;
    }

    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "field.required");
        Customer customer = (Customer) target;
        try {
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator, customer, errors);
        } finally {
            errors.popNestedPath();
        }
    }
}