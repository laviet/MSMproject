package com.group15.msm.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {
}
