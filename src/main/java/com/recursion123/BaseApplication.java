package com.recursion123;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by zhang on 2016/11/15.
 * BaseApplication
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class BaseApplication extends SpringBootServletInitializer{

//    //部署到外部tomcat
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder config) {
//        return config.sources(BaseApplication.class);
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BaseApplication.class,args);
    }
}
