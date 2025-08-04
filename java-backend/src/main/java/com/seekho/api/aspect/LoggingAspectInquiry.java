package com.seekho.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectInquiry {

    // BEFORE any InquiryServiceImpl method
    @Before("execution(* com.seekho.api.serviceImpl.InquiryServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Method Called: " + joinPoint.getSignature().getName());
    }

    // AFTER successfully returning
    @AfterReturning("execution(* com.seekho.api.serviceImpl.InquiryServiceImpl.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(" Method Completed: " + joinPoint.getSignature().getName());
    }

// AOP implementation
// AROUND advice to log execution time
//    @Around("execution(* com.seekho.api.serviceImpl.InquiryServiceImpl.*(..))")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = joinPoint.proceed(); // continue to the original method
//        long end = System.currentTimeMillis();
//
//        System.out.println("Execution Time for " + joinPoint.getSignature().getName() + ": " + (end - start) + " ms");
//        return result;
//    }

    // Artificial Delay ---test 2.
    @Around("execution(* com.seekho.api.serviceImpl.InquiryServiceImpl.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // execute actual method
        long end = System.currentTimeMillis();

        long duration = end - start;

        if (duration > 2000) {
            System.out.println("⚠️ WARNING: " + joinPoint.getSignature().getName() + " took " + duration + " ms (> 2s)");
        } else {
            System.out.println("⏱️ Execution Time for " + joinPoint.getSignature().getName() + ": " + duration + " ms");
        }

        return result;
    }

}
