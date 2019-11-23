package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.Date;

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
    @Past(message = "the birth is must great than current day")
    private Date ngaysinh;
    private String diachi;
    private String sdt;
    private Date thoigiancapnhat;
}
