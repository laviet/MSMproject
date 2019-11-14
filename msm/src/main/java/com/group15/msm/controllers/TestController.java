package com.group15.msm.controllers;

import com.group15.msm.config.CustomUserDetails;
import com.group15.msm.security.CurrentUser;
import com.group15.msm.security.IsAdmin;
import com.group15.msm.test.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class TestController {


    @GetMapping()
    public String defaultMethod() {
        return "this is default method";
    }

    @GetMapping("/method1")
    public String method1() {
        return "this is method 1";
    }

    @GetMapping("/method2")
    public String method2() {
        return "this is method 2";
    }

    @GetMapping("/hello")
    public String method3() {
        return "this is hello";
    }

    @GetMapping("/user")
    public String getUser() {
        return "this is user";
    }
    @GetMapping("/admin")
    public String getAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());
        Object object=authentication.getPrincipal();
        String name="";
        String pass="";
        if(object instanceof UserDetails){
            name=((UserDetails) object).getUsername();
            pass=((UserDetails) object).getPassword();
            ((UserDetails) object).getAuthorities();
        }
        String currentPrincipalName = authentication.getName();
        System.out.println("day la thuoc tinh: "+currentPrincipalName);
        System.out.println("this name: "+name);
        System.out.println("this pass: "+pass);
        return "this is admin";
    }
    @GetMapping("/check")
    @RolesAllowed("ROLE_ADMIN")
    public String checkRole() {
        return "this is check role";
    }
    @GetMapping("/foradmin")
    @IsAdmin
    public String forAdmin(@CurrentUser CustomUserDetails user) {
        Test test=new Test();
        System.out.println(user);
        return "this is for admin"+ test.getStringABC();
    }
}
