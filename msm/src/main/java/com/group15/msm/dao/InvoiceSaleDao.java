package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 08:16
 */
@Setter
@Getter
@Entity
@Table(name = "hoadonbanhang")
public class InvoiceSaleDao {
    @Id
    private String id;
    @Column(nullable = false)
    private Date ngayban;
    @Column(name = "khachhang_id", nullable = false)
    private int khachhangId;
    @Column(name = "nhanvien_id", nullable = false)
    private int nhanvienId;
}
