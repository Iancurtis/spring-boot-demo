package com.example.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {

    @Pointcut("execution(* transfer(..))")
    public void anyOldTransfer() {
    }

    @Before("execution(* transfer(..))")
    public void beforeTransfer() {
        System.out.println("aop before transfer...");
    }

    @AfterReturning(value = "anyOldTransfer()")
    public void afterTransfer() {
        System.out.println("aop after tranfer returning...");
    }

    @AfterThrowing(value = "anyOldTransfer()", throwing = "ex")
    public void AfterThrowingTransfer(Exception ex) {
        System.out.println("aop after transfer thowing: " + ex.getMessage());
    }

    public void AfterTransfer() {
        
    }
}