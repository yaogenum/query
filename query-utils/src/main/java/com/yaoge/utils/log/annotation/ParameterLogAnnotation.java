package com.yaoge.utils.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 类ParameterLogAnnotation.java的实现描述：纪录日志 
 * @author yaoge 2015年8月23日 下午5:55:58
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParameterLogAnnotation {
    String logContent() default "log4j" ;
    String logClassName() default "this.class";
}
