package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 23-11-2019
 * Time: 16:19
 */
@Setter
@Getter
@Entity
@Table(name = "nhacungcap")
public class SupplierDao {
    @Id
    private String id;
    private String tennhacungcap;
    private String diachi;
}
