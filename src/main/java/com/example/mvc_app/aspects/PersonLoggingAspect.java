package com.example.mvc_app.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonLoggingAspect {

    @Around("execution(* com.example.mvc_app.service.impl.*.*(..))")
    public Object aroundAllServiceMethodsAdvise(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of "+ methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of "+methodName);

        return targetMethodResult;
    }
}
