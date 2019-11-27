package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.CustomerDao;
import com.group15.msm.repository.CustomerRepository;
import com.group15.msm.service.serviceInterface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 22-11-2019
 * Time: 09:56
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Optional<CustomerDao> getCutomerById(int id) {
        return repository.findById(id);
    }

    @Override
    public CustomerDao setCustomer(CustomerDao customerDao) {
        return repository.save(customerDao);
    }

    @Override
    public Iterable<CustomerDao> getAllCustomer() {
        return repository.findAll();
    }
}
