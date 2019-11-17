package com.group15.msm.controllers;
import com.group15.msm.security.CurrentUser;
import com.group15.msm.security.service.UserPrinciple;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: laviet
 * Version: 1.0
 * Create date: 15-11-2019
 * Time: 00:09
 */
@RestController
public class TestRestAPIs {
    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/api/test/pm")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess(@CurrentUser UserPrinciple userPrincipal) {
        System.out.println(userPrincipal.getUsername());
        System.out.println("vao day roi");
        return ">>> Board Management Project";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }
    @GetMapping("/norole")
    public String testMethod1(){
        return "no role";
    }
    @GetMapping("/denied")
    public String testMethod2(){
        return "try cap denied";
    }
}
