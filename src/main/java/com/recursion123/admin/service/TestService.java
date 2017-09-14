package com.recursion123.admin.service;

import com.recursion123.admin.model.Role;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class TestService {

    @WebMethod
    public Role test(@WebParam(name = "hehe",partName="role") Role hehe){
        System.out.println(hehe);
        return new Role(11,"113");
    }
}
