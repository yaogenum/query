
package com.cqupt.yaoge.book.query.tag.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AopA {
    
    @After("execution(* com.cqupt.yaoge.book.query.tag.test.TestSourceA.*(..))")
    public void afterSource1(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestSource sysProxy AOP");
    }
    //@Before("execution(* com.cqupt.yaoge.book.query.tag.test.TestSourceAextend.*(..))")
    public void afterSource2(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("before aspect executing TestSource sysProxy AOP");
    }
/**    
    @Before("execution(* com.cqupt.yaoge.book.query.tag.test.TestA.sysA(..))")
    public void before(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestA sysA");
    }
    
    @Before("execution(* com.cqupt.yaoge.book.query.tag.test.TestA.sysAsourceSecod(..))")
    public void beforesecond(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestA sysAsourceSecod");
    }

    @Before("execution(* com.cqupt.yaoge.book.query.tag.test.TestA.sysAsource(..))")
    public void beforesource(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestA source");
    }
    
    @After("execution(* com.cqupt.yaoge.book.query.tag.test.TestB.sysB(..))")
    public void after(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestB sysB");
    }
    
 **/
   /** @After("execution(* com.cqupt.yaoge.book.query.tag.test.TestProxy.sysProxy(..))")
    public void after(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestA sysProxy AOP");
    }
    
    @After("execution(* com.cqupt.yaoge.book.query.tag.test.TestSource.*(..))")
    public void afterSource(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestSource sysProxy AOP");
    }
    
    @After("execution(* com.cqupt.yaoge.book.query.tag.test.TestB.*(..))")
    public void afterSourceB(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        //Object[] args = joinPoint.getArgs();
        System.out.println("after aspect executing TestSource sysProxy AOP BB");
    }*/
    
}
