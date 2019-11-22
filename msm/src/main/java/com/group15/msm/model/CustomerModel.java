package com.group15.msm.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 22-11-2019
 * Time: 09:54
 */
@Getter
@Setter
public class CustomerModel {
    private int makhachhang;
    @NotBlank
    private String tenkhachhang;
    private String email;
    private String gioitinh;
    private String diachi;
    private String sdt;
}
