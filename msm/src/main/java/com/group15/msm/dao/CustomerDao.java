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
 * Create date: 22-11-2019
 * Time: 09:51
 */
@Setter
@Getter
@Entity
@Table(name = "khachhang")
public class CustomerDao {
    @Id
    private int makhachhang;
    @Column(nullable = false)
    private String tenkhachhang;
    private String email;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private Date thoigiancapnhat;
}
