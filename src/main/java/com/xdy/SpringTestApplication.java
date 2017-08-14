package com.xdy;

import com.xdy.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * User: xuedaiyao
 * Date: 2017/8/10
 * Time: 18:21
 * Description:  @SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan。
 */
@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableAsync
public class SpringTestApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class,args);
    }
}
