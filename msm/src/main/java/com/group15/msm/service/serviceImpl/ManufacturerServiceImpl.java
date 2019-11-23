package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.ManufacturerDao;
import com.group15.msm.repository.ManufacturerRepository;
import com.group15.msm.service.serviceInterface.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 00:20
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    ManufacturerRepository repository;

    @Override
    public Iterable<ManufacturerDao> getAllManufacturer() {
        return repository.findAll();
    }
}
