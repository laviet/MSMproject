package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 08:25
 */
@Setter
@Getter
@Entity
@Table(name = "hoadonnhap")
public class ImportInvoiceDao {
    @Id
    @Size(min = 8)
    private String id;
    @Column(nullable = false)
    private Date ngaynhap;
    @Column(name="nhacungcap_id",nullable = false)
    private String nhacungcapId;
    @Column(name="nhanvien_id",nullable = false)
    @Min(value = 1)
    private int nhanvienId;
}
