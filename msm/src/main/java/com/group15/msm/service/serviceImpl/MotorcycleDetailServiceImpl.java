package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.MotorcycleDetailDao;
import com.group15.msm.repository.MotorcycleDetailRepository;
import com.group15.msm.service.serviceInterface.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:36
 */
@Service
public class MotorcycleDetailServiceImpl implements MotorcycleService {
    @Autowired
    MotorcycleDetailRepository repository;

    @Override
    public MotorcycleDetailDao setMotorcycleDetial(MotorcycleDetailDao detailDao) {
       return repository.save(detailDao);
    }
}
