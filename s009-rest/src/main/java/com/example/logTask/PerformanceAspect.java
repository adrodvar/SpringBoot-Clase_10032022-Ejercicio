package com.example.logTask;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceAspect {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.example.controllers.TaskController..*(..))")
    public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        long start = System.currentTimeMillis();

        StopWatch timer = new StopWatch();
        timer.start();
        Object result = joinPoint.proceed(); // ejecución del método real
        timer.stop();
        timer.getTotalTimeMillis();

        long stop = System.currentTimeMillis();
        long total = stop - start;
        log.debug("{} total execution time {} ms", joinPoint.getSignature().getName(), total);
        if(total > 50)
            log.warn("{} {} slow method!",
                    methodSignature.getDeclaringTypeName(),
                    methodSignature.getName());

        return result;
    }
}
