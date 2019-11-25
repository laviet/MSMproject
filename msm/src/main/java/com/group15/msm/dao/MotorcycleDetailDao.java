package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:27
 */
@Setter
@Getter
@Entity
@Table(name = "chitietxe")
public class MotorcycleDetailDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sokhung;
    private String somay;
    @Column(name="chitietnhap_id", nullable = false)
    private int chitietnhapId;
    @Column(name="chitiethoadon_id")
    private int chitiethoadonId;
}
