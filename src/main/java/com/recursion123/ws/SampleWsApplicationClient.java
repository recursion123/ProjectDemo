package com.recursion123.ws;


import com.recursion123.model.User;
import com.recursion123.service.UserService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;


//CHECKSTYLE:OFF
public class SampleWsApplicationClient {
    private static JaxWsProxyFactoryBean factory=new JaxWsProxyFactoryBean();
    public static Object getBean(String url,Class<?> serviceClass){
        factory.setServiceClass(serviceClass);
        factory.setAddress(url);
        UserService userService=(UserService)factory.create();
        return userService;
    }

    public static void main(String[] args) throws Exception {
        String address = "http://localhost:8080/api/services/UserService";
        UserService userService=(UserService)SampleWsApplicationClient.getBean("http://localhost:8080/api/services/UserService?wsdl", UserService.class);
        System.out.println(userService.listUser(new User("su","123",null)));
    }
}
