package com.seekho.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectPayment {

    // BASIC LOG BEFORE PAYMENT METHODS
    @Before("execution(* com.seekho.api.serviceImpl.PaymentServiceImpl.*(..))")
    public void logBeforePaymentMethod(JoinPoint joinPoint) {
        System.out.println("💳 [PAYMENT] Starting: " + joinPoint.getSignature().getName());
    }

    // BASIC LOG AFTER PAYMENT METHODS
    @AfterReturning("execution(* com.seekho.api.serviceImpl.PaymentServiceImpl.*(..))")
    public void logAfterPaymentMethod(JoinPoint joinPoint) {
        System.out.println("✅ [PAYMENT] Completed: " + joinPoint.getSignature().getName());
    }

    // MONITOR EXECUTION TIME (like for future Razorpay integration)
    @Around("execution(* com.seekho.api.serviceImpl.PaymentServiceImpl.*(..))")
    public Object monitorPaymentTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // proceed to actual method
        long end = System.currentTimeMillis();

        long duration = end - start;

        if (duration > 20000) { // 20 seconds threshold
            System.out.println("⛔ [PAYMENT ALERT] Method " + joinPoint.getSignature().getName() +
                    " took too long: " + duration + " ms (exceeded 20 sec limit)");
        } else {
            System.out.println("⏱️ [PAYMENT] Time for " + joinPoint.getSignature().getName() + ": " + duration + " ms");
        }

        return result;
    }
}
