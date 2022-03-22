package com.example.logTask;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /*
            =========== POINT CUTS ==============
     */
    @Pointcut("execution(* com.example.service.EmployeeService.findByName (..))")
    public void findAllPointCut(){}

    @Pointcut("@annotation(com.example.logTask.Logging)")
    public void loggingAnnotationPointCut(){}

//    @Pointcut("within(com.example.service..*) || within(com.example.controllers..*)")
    @Pointcut("within(com.example.service..*)")
    public void packagePointCut(){}

//    @Pointcut("execution(* com.example..*(..))")
//    public void allMethods(){}


    /*
            ============ ADVICES ==============
     */
    @Before("findAllPointCut()")
    public void beforeFindAll(JoinPoint joinPoint){
        log.debug("Before > {}", joinPoint.getSignature().getName());
    }

//    @After("allMethods()")
//    public void afterAll(JoinPoint joinPoint){
//        log.debug("After > {}", joinPoint.getSignature().getName());
//
//    }

    @After("loggingAnnotationPointCut()")
    public void afterLoggingAnnotation(JoinPoint joinPoint){
        log.debug("After > {}", joinPoint.getSignature().getName());
    }

//    @Before("packagePointCut() || findAllPointCut()")  // se pueden combinar varios pointcuts
    @Before("packagePointCut()")
    public void servicePackage(JoinPoint joinPoint){
        log.debug("After > {}", joinPoint.getSignature().getName());
    }


}











