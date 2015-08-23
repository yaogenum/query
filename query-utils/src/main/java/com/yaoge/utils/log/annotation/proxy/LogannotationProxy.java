package com.yaoge.utils.log.annotation.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.yaoge.utils.log.annotation.ParameterLogAnnotation;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 类LogannotationProxy.java的实现描述：jdk+annotation
 * 
 * @author yaoge 2015年8月23日 下午6:03:43
 */
public class LogannotationProxy implements MethodInterceptor {

    private Object target;
    private Logger logger = null;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {

        logger = Logger.getLogger(target.getClass());
        logger.info("proxy logger start");
        String logContent = null;
        try {
            logContent = getLogParamByAnnotationReflect(method, params);
            if (StringUtils.isBlank(logContent)) {
                logContent = getLogParamNameByJavassit(target.getClass(),method, params);
            }

            logger.info(logContent);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info("proxy logger end");
        return proxy.invokeSuper(target, params);
    }

    private String getLogParamByAnnotationReflect(Method method, Object[] params) {
        if (null == method || StringUtils.isBlank(method.getName())) return null;
        if (method.getParameterAnnotations().length <= 0) return null;
        StringBuilder logContent = new StringBuilder();
        Annotation methodAnnotation[][] = method.getParameterAnnotations();
        for (int index = 0; index < params.length; index++) {
            Annotation[] paramAnnotations = methodAnnotation[index];
            if (null == paramAnnotations || paramAnnotations.length <= 0) continue;
            for (Annotation an : paramAnnotations) {
                if (an instanceof ParameterLogAnnotation) {
                    ParameterLogAnnotation paramLogannotation = (ParameterLogAnnotation) an;
                    logContent.append("className:").append(paramLogannotation.logClassName()).append("|logcontent:").append(params[index]);
                }
            }

        }
        return logContent.toString().trim();
    }

    private String getLogParamNameByJavassit(Class<?> T, Method method, Object[] params) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get(T.getName());
            CtMethod cm = cc.getDeclaredMethod(method.getName());
            StringBuilder logContent = new StringBuilder();

            cm = cc.getDeclaredMethod(method.getName());
            // 使用javaassist的反射方法获取方法的参数名
            MethodInfo methodInfo = cm.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if (null == attr) return null;
            String[] paramNames = new String[cm.getParameterTypes().length];
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
            // paramNames即参数名,匹配参数值
            for (int i = 0; i < paramNames.length; i++) {
                paramNames[i] = attr.variableName(i + pos);
                logContent.append(paramNames[i]).append(":").append(params[i]).append("|");
            }
            // 可以获取方法注解
            // cm.getAnnotations();
            // cm.getParameterAnnotations();
            return logContent.toString();

        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            logger.error(e.getMessage());
        }
        return null;
    }

}
