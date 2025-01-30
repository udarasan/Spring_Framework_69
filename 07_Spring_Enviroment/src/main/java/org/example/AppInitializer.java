package org.example;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        //system environment variables
        /*Map<String,String> env=System.getenv();
        for (String key : env.keySet()) {
            System.out.println(key+"="+env.get(key));
        }
        System.out.println(env.get("PROCESSOR_LEVEL"));*/

        //Access Predefined Properties From Java
        /*Properties properties=System.getProperties();
        *//*for (String key : properties.stringPropertyNames()) {
            System.out.println(key+"="+properties.getProperty(key));
        }*//*
        System.out.println(System.getProperty("os.name"));*/

        context.registerShutdownHook();

    }
}
