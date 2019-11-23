package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 00:14
 */
@Setter
@Getter
@Entity
@Table(name = "hangsanxuat")
public class ManufacturerDao {
    @Id
    private String id;
    private String tenhang;
    private String tennuoc;
}
