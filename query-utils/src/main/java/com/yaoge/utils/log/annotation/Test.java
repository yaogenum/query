package com.yaoge.utils.log.annotation;

import com.yaoge.utils.log.annotation.proxy.LogannotationProxy;


public class Test {
    public static void main(String args[]) {
        TestParam p = new TestParam();
        LogannotationProxy proxy = new LogannotationProxy();
        TestParam t = (TestParam) proxy.getInstance(p);
        t.testParam("logcontent is lall log4j", t.getClass().getName());
    }
}
