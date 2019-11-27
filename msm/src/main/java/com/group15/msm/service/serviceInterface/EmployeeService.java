package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.EmployeeDao;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 09:06
 */
public interface EmployeeService {
    Optional<EmployeeDao> getEmployeeById(int id);

    EmployeeDao setEmployee(EmployeeDao employeeDao);

    Iterable<EmployeeDao> getAllEmployee();
}
