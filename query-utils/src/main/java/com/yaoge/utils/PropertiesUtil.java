package com.yaoge.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 类PropertiesUtil.java的实现描述：TODO 类实现描述 
 * @author yaoge 2015年8月23日 上午1:36:53
 */

public class PropertiesUtil {
    public static void main(String args[]) {
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(getPath(PropertiesUtil.class,"prac.properties")));
            FileInputStream file = getFileInputStream(PropertiesUtil.class,"prac.properties") ;
            byte[] arrays = new byte[10];
            file.read(arrays);
            System.out.println(new String(arrays));
            System.out.println(property.getProperty("value"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPath(Class<?> c , String propertiesName) {
        return c.getResource(File.separator+propertiesName).getPath();
    }
    
    public static InputStream getPathInputStream(Class<?> c,String propertiesName) {
        return (InputStream) c.getResourceAsStream(File.separator+propertiesName) ;
    }
    
    public static FileInputStream getFileInputStream(Class<?> c , String propertiesName) {
        try {
            return new FileInputStream(getPath(c,propertiesName));
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
