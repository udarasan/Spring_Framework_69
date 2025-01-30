package org.example;

import org.example.bean.*;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.processing.SupportedOptions;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        TestBean1 ref1 = context.getBean(TestBean1.class);
        System.out.println(ref1);
        TestBean1 ref2 = context.getBean(TestBean1.class);
        System.out.println(ref2);
        TestBean1 ref3 = context.getBean(TestBean1.class);
        System.out.println(ref3);

        MyConnection ref4 = context.getBean(MyConnection.class);
        System.out.println(ref4);
        MyConnection ref5 = context.getBean(MyConnection.class);
        System.out.println(ref5);

        context.registerShutdownHook();

    }
}
