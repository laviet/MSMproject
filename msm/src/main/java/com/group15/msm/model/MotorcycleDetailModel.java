package com.group15.msm.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:38
 */
@Getter
@Setter
public class MotorcycleDetailModel {
    private String sokhung;
    private String somay;
    @Min(value = 1)
    private int chitietnhapId;
    private int chitiethoadonId;
}
