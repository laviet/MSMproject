package com.group15.msm.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 09:14
 */
@Getter
@Setter
public class EmployeeModel {
    private int manhanvien;
    @NotBlank
    private String tennhanvien;
    @NotBlank
    @Email
    private String email;
    private String gioitinh;
    private String diachi;
    private String sdt;
}
