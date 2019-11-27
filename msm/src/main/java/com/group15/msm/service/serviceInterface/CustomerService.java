package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.CustomerDao;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 22-11-2019
 * Time: 09:56
 */
public interface CustomerService {
    Optional<CustomerDao> getCutomerById(int id);

    CustomerDao setCustomer(CustomerDao customerDao);

    Iterable<CustomerDao> getAllCustomer();
}
