package com.test.calculator.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Aspect
@Configuration
public class LoggingHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.test.calculator.api.*)")
    public void controller() {
    }

    @Pointcut("execution(* com.test.calculator.api.*.*(..))")
    public void allMethods() {
    }

    @Before("execution(* com.test.calculator.api.*.*(..))")
    public void before(JoinPoint joinPoint) {
        this.logger.info("Running -> {} ", joinPoint.getSignature());
    }

    @After("controller() && allMethods()")
    public void after(JoinPoint joinPoint) {
        this.logger.info("Input data -> {} ", joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "controller() && allMethods()", returning = "result")
    public void logAfter(JoinPoint joinPoint, ResponseEntity<?> result) {
        this.logger.info("Return -> " + this.getValue(result));
    }

    private String getValue(ResponseEntity<?> result) {
        return "Status Code: " + result.getStatusCode().toString() + " -> Result: " + result.getBody();
    }
}