package com.group15.msm.repository;

import com.group15.msm.dao.CustomerDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 22-11-2019
 * Time: 09:55
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerDao, Integer> {

}
