package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 08:45
 */
@Setter
@Getter
@Entity
@Table(name = "nhanvien")
public class EmployeeDao {
    @Id
    private int manhanvien;
    private String tennhanvien;
    @Column(unique = true)
    @Email
    private String email;
    private String gioitinh;
    private String diachi;
    private String sdt;
}
