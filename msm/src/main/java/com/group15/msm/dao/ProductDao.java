package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 14:52
 */
@Setter
@Getter
@Entity
@Table(name = "sanpham")
public class ProductDao {
    @Id
    private String id;
    @Column(nullable = false)
    private String loaisanpham;
    @Column(nullable = false)
    private String tensanpham;
    private String phankhoi;
    private String mausac;
    @Column(nullable = false)
    private double dongia;
    @Column(name = "hangsanxuat_id", nullable = false)
    private String hangsanxuatId;
}
