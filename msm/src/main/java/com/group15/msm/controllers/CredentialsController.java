package com.group15.msm.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 14-11-2019
 * Time: 17:28
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CredentialsController {
    @GetMapping("/test")
    public String test() {
        return "this is spring boot +vuejs";
    }
}
