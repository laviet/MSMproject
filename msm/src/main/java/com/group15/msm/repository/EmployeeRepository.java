package com.group15.msm.repository;

import com.group15.msm.dao.EmployeeDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 09:05
 */
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDao, Integer> {
}
