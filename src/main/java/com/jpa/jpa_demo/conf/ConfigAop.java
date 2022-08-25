package com.jpa.jpa_demo.conf;

import com.jpa.jpa_demo.aspectj.InsertAspects;
import com.jpa.jpa_demo.aspectj.SelectAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author
 * @Date 2022/8/25
 * @DESC
 */
@Configuration
@EnableAspectJAutoProxy
public class ConfigAop {
    @Bean
    public SelectAspects selectAspects() {
        return new SelectAspects();
    }

    @Bean
    public InsertAspects insertAspects() {
        return new InsertAspects();
    }
}
