package com.cqupt.yaoge.book.query.tag.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.cglib.core.ClassGenerator;
import net.sf.cglib.core.DebuggingClassWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
       // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/yaoge/Desktop/jdkProxy/cglib");
        ApplicationContext context = new ClassPathXmlApplicationContext("testTag.xml");
        SimpleDateFormat format = (SimpleDateFormat) context.getBean("defaultDateFormat");
        System.out.println(format.format(new Date()));
        TestSource a =(TestSource)context.getBean("testC");
        a.sysAsourceSecod();
        a.sysAsource();
        TestSourceA t = new TestSourceA(); 
        InputStream input = t.getClass().getResourceAsStream("TestSourceA.class");
        try {
            if(input ==null) {
                return ;
            }
            FileOutputStream file = new FileOutputStream("/Users/yaoge/Desktop/jdkProxy/jdkclass/ApplicationContext.class");
            byte[] bytes = new byte[1024];
            try {
                while(input.read(bytes) != -1) {
                    file.write(bytes);
                }
                try {
                    input.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        for(Method method : a.getClass().getInterfaces()[1].getClass().getMethods()) {
//        }
        /**
         * JDK动态代理
         */
        /**
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "/Users/yaoge/Desktop/jdkProxy/");
        ProxyGeneratorUtils.writeProxyClassToHardDisk("/Users/yaoge/Desktop/jdkProxy/$ProxyNoJdkProxy.class",a.getClass());
        **/
        //a.sysAsource();
//        a.sysA();
//        a.sysB();
//        a.sysAsource();
        //a.sysAsourceSecod();
        
    }
}
