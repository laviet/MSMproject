package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 09:27
 */
@Setter
@Getter
@Entity
@Table(name = "chitiethoadon")
public class InvoiceDetailDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="hoadonbanhang_id", nullable = false)
    private String hoadonbanhangId;
    @Column(name="sanpham_id", nullable = false)
    private String sanphamId;
    @Min(value = 1)
    @Column(nullable = false)
    private int soluong;
    @Column(nullable = false)
    private double dongia;
}
