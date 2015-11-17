package com.cqupt.yaoge.book.query.tag.parser;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import java.text.SimpleDateFormat;
/**
 * Created by yaoge on 15/11/17.
 */
public class MyTagParser extends AbstractSingleBeanDefinitionParser{
    protected Class<SimpleDateFormat> getBeanClass(Element element) {
        return SimpleDateFormat.class;
    }

    @SuppressWarnings("deprecation")
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        // this will never be null since the schema explicitly requires that a value be supplied
        String pattern = element.getAttribute("pattern");
        bean.addConstructorArg(pattern);

        // this however is an optional property
        String lenient = element.getAttribute("lenient");
        if (StringUtils.hasText(lenient)) {
            bean.addPropertyValue("lenient", Boolean.valueOf(lenient));
        }
    }
}
