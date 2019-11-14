package com.group15.msm.test;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//@EnableGlobalMethodSecurity(
//        prePostEnabled = true
//)
public class Test {
    @PreAuthorize("hasRole('ADMIN')")
    public String getStringABC(){
        return "ab hoasidfac";
    }
}
