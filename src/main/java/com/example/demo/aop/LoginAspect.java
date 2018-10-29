package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2018/10/29/029 10:56
 * @Version: 1.0
 * @Description:
 */
@Aspect
@Component
public class LoginAspect {
    @Pointcut(value = "@annotation(com.example.demo.aop.Auth)")
    public void access(){

    }

    @Before("access()")
    public void before(){
        System.out.println("开始验证是否登录 ==>> ");
    }
    @Around("@annotation(auth)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Auth auth){
        System.out.println("注解中的值： " + auth.desc());
        try {
            Boolean flag = false;
            if (flag){
                return "登录成功";
            }else {
                return "未登录";
            }
        }catch (Throwable throwable){
            return null;
        }
    }
}
