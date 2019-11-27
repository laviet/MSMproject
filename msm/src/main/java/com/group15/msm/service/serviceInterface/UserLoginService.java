package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.UserDao;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 08:50
 */
public interface UserLoginService {
    Optional<UserDao> getUserById(int id);

    void updateUser(UserDao userDao);

}
