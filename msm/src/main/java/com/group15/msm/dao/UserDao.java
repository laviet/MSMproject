package com.group15.msm.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 20-11-2019
 * Time: 23:44
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
}
