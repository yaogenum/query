package com.cqupt.yaoge.book.query.tag.test;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.cglib.core.ClassGenerator;
import sun.misc.ProxyGenerator;  

/** 
 * 代理类的生成工具 
 * @author zyb 
 * @since 2012-8-9 
 */  
public class ProxyGeneratorUtils {  
  
    /** 
     * 把代理类的字节码写到硬盘上 
     * @param path 保存路径 
     */  
    public static void writeProxyClassToHardDisk(String path,Class a) {  
        // 第一种方法，这种方式在刚才分析ProxyGenerator时已经知道了  
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);  
          
        // 第二种方法  
          
        // 获取代理类的字节码  
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", a.getInterfaces());
        
        //classFile = a.get
        FileOutputStream out = null;  
          
        try {  
            out = new FileOutputStream(path);  
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  