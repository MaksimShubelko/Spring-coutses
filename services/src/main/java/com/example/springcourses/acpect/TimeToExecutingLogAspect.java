package com.example.springcourses.acpect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeToExecutingLogAspect {

    @Around("@annotation(TimeToExecutingLog)")
    public Object logTimeToExecuting(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("The method {} was executed for {} mills", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
