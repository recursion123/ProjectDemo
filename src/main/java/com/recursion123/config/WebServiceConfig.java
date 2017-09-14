package com.recursion123.config;

import com.recursion123.admin.service.TestService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import javax.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new TestService());
        endpoint.publish("/TestService");
        return endpoint;
    }
}