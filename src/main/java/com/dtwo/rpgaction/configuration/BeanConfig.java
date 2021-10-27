package com.dtwo.rpgaction.configuration;

import com.dtwo.rpgaction.model.commons.ScopeContext;
import com.dtwo.rpgaction.scopes.commons.ScopeProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class BeanConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    /*
    * Singleton scope bean definitions
    * This code bit contains beans that are required for the scope execution
    * **/

    @Bean
    public ScopeContext scopeContext() { return new ScopeContext(); }

    @Bean
    @RequestScope
    public ApplicationContext flowScope() {
        return new ClassPathXmlApplicationContext("flow-scope.xml");
    }

    @Bean("newUserScope")
    @RequestScope
    public ScopeProcessor newUserScope() {
        return (ScopeProcessor) flowScope().getBean("newUserScope");
    }
}