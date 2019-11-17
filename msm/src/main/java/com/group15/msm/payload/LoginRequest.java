package com.group15.msm.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author: laviet
 * version: 1.0
 * create date: 14-11-2019
 * time: 16:35
 */
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
