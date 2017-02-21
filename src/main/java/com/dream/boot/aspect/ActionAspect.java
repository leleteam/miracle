package com.dream.boot.aspect;

import com.dream.boot.annotations.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ActionAspect {

    @Pointcut("@annotation(com.dream.boot.annotations.Action)")
    public void annotationPointCut() {}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截: " + action.name());
    }

    @Before("execution(* com.dream.site.controller.*.*.*(..))")
    public void siteBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法式拦截: " + method.getName());
    }

    @Before("execution(* com.dream.admin.controller.*.*.*(..))")
    public void adminBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法式拦截: " + method.getName());
    }

}
