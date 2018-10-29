package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2018/10/29/029 10:01
 * @Version: 1.0
 * @Description:
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void loginLog(){

    }

    @Before("loginLog()")
    public void loginBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println(
                "请求路径 ： " + request.getRequestURL() + "\r\n"
                + "请求方式 ： " + request.getMethod() + "\r\n"
                + "方法名 ： " + joinPoint.getSignature().getName() + "\r\n"
                + "参数 ： " + Arrays.toString(joinPoint.getArgs())
        );
    }

    @AfterReturning(returning = "object", pointcut = "loginLog()")
    public void doAfterReturning(Object object){
        System.out.println("返回值 ： " + object);
    }

    @AfterThrowing(throwing = "e", pointcut = "loginLog()")
    public void throwsExecute(JoinPoint joinPoint, Exception e){
        System.out.println("方法异常 ： " + e.getMessage());
    }
    @Around("loginLog()")
    public Object surroundInform(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知开始 ==>> ");
        try {
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("方法环绕 proceed, 结果是 ： " + proceed);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
