package com.group15.msm.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 19-11-2019
 * Time: 15:05
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('EMPLOYEE')")
public @interface IsCustomer {

}
