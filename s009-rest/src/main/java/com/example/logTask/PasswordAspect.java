package com.example.logTask;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PasswordAspect {

    Logger log = LoggerFactory.getLogger(this.getClass());


    @AfterReturning(pointcut = "execution(* com.example.components.PasswordGenerator.generate(..))",
            returning = "password")
    public void checkPassword(JoinPoint joinPoint, Object password){
        if(password.toString().length() < 15)
            log.warn("Password length not secure!");

    }
}
