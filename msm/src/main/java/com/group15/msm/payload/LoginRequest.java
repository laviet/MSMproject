package com.group15.msm.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: laviet
 * version: 1.0
 * create date: 14-11-2019
 * time: 16:35
 */
@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;

}
