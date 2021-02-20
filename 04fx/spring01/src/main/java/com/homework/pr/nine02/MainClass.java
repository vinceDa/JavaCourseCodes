package com.homework.pr.nine02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ohYoung
 * @date 2021/2/21 0:50
 */
public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BasePojo xmlBasePojo = (BasePojo) context.getBean("xmlBasePojo");
        xmlBasePojo.sayRefType();

        BasePojo annotationBasePojo = (BasePojo) context.getBean("annotationBasePojo");
        annotationBasePojo.sayRefType();

        ConfigBasePojo configBasePojo = (ConfigBasePojo) context.getBean("configBasePojo");
        configBasePojo.sayRefType();
    }

}
