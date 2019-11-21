package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.UserDao;
import com.group15.msm.repository.UserLoginRepository;
import com.group15.msm.service.serviceInterface.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 08:51
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginRepository repository;

    @Override
    public void updateUser(UserDao userDao) {
        repository.setUser(userDao.getEmail(), userDao.getName(), userDao.getId());
    }

    @Override
    public Optional<UserDao> getUserById(int id) {
        return repository.findById(id);
    }
}
