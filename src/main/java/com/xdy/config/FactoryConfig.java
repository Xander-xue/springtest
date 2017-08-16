package com.xdy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * User: xuedaiyao
 * Date: 2017/8/16
 * Time: 13:22
 * Description:
 */

@Configuration
@EnableAutoConfiguration
public class FactoryConfig {

    final static Logger logger = LoggerFactory.getLogger(FactoryConfig.class);

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}