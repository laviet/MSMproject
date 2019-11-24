package com.group15.msm.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 14:06
 */
@Getter
@Setter
public class ImportModel {
    @NotBlank
    private String id;
    @Past
    private Date ngaynhap;
    @NotBlank
    private String nhacungcapId;
    @Min(value = 0)
    private int nhanvienId;
    @NotBlank
    private String sanphamId;
    @Min(value = 1)
    private int soluong;
    @Min(value =0)
    private double dongia;
}
