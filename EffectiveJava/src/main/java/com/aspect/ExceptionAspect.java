package com.aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExceptionAspect {
    // 예외 발생 시 실행될 advice를 정의합니다.
    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) {
        // 예외 처리 로직을 작성합니다.
        System.out.println("전 발생!!!");

    }

    @Before(value = "execution(* *(..))")
    public void handleException2(JoinPoint joinPoint, Exception ex) {
        // 예외 처리 로직을 작성합니다.
        System.out.println("후 발생!!!");

    }

    @Around(value = "execution(* *(..))")
    public void handler3() {
        System.out.println("around@@@!!!");
    }
}


