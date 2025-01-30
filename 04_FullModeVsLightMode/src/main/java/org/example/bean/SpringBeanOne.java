package org.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne {
    @Bean
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
    }
}
