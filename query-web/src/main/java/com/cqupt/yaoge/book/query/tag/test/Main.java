package com.cqupt.yaoge.book.query.tag.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Thread().sleep(20000);
        ApplicationContext context = new ClassPathXmlApplicationContext("testTag.xml");
        TestSource c = (TestSource) context.getBean("testC");
        c.sysAsource();
        c.sysAsourceSecod();
        try {
            new Thread().sleep(300000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
