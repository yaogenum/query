package com.cqupt.yaoge.book.query.tag.handler;

import com.cqupt.yaoge.book.query.tag.parser.MyTagParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by yaoge on 15/11/17.
 */
public class MyTagHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("format", new MyTagParser());
    }
}
