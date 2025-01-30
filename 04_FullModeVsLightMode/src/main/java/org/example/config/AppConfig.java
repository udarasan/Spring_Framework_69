package org.example.config;

import org.example.bean.SpringBeanThree;
import org.example.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {
/*    @Bean
    public SpringBeanTwo getSpringBeanTwo() {
        SpringBeanThree springBeanThree1 = getSpringBeanThree();
        SpringBeanThree springBeanThree2 = getSpringBeanThree();
        System.out.println(springBeanThree1);
        System.out.println(springBeanThree2);
        return new SpringBeanTwo();
    }
    @Bean
    public SpringBeanThree getSpringBeanThree() {
        return new SpringBeanThree();
    }*/
}
