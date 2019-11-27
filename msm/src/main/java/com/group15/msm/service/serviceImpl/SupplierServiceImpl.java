package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.SupplierDao;
import com.group15.msm.repository.SupplierRepository;
import com.group15.msm.service.serviceInterface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 23-11-2019
 * Time: 16:25
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository repository;

    @Override
    public Iterable<SupplierDao> getAllSupplier() {
        return repository.findAll();
    }
}
