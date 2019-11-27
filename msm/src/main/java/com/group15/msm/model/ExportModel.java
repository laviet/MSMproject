package com.group15.msm.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 10:40
 */
@Getter
@Setter
public class ExportModel {
    @NotBlank
    @Size(min = 8)
    private String id;
    @Past
    private Date ngayban;
    @Min(value = 0)
    private int nhanvienId;
    @Min(value = 0)
    private int khachhangId;
    @NotBlank
    private String sanphamId;
    @Min(value = 1)
    private int soluong;
    @Min(value = 0)
    private double dongia;
}
