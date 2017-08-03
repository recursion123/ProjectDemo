package com.recursion123;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zhang on 2016/11/15.
 * BaseApplication
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
@ComponentScan("com")
public class BaseApplication extends SpringBootServletInitializer {
    //    //部署到外部tomcat
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder config) {
//        return config.sources(BaseApplication.class);
//    }

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
//        return bean;
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BaseApplication.class, args);
    }
}
