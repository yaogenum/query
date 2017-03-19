package com.cqupt.yaoge.book.query.tag.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TestExtendsProxy {
    
  //  @Before("execution(* com.cqupt.yaoge.book.query.tag.test.TestSource.*(..))")
    public void before(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("new before aspect executing TestA sysA");
    }
    
}
