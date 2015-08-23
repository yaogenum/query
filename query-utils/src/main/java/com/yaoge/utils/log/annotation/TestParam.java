package com.yaoge.utils.log.annotation;
/**
 * 
 * 类TestParam.java的实现描述：TODO 类实现描述 
 * @author yaoge 2015年8月23日 下午8:24:26
 */
public class TestParam {

    public void testParam(@ParameterLogAnnotation(logContent = "logContent", logClassName = "logClassName") String name,
                          String pass) {
        System.out.println(name + "||" + pass);
    }
}
