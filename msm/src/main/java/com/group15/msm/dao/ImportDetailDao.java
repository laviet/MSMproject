package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 08:30
 */
@Setter
@Getter
@Entity
@Table(name = "chitietnhap")
public class ImportDetailDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="sanpham_id", nullable = false)
    private String sanphamId;
    @Min(value = 1)
    private int soluong;
    @Min(value =0)
    private double dongia;
    @Column(name="hoadonnhap_id", nullable = false)
    private String hoadonnhapId;
}
