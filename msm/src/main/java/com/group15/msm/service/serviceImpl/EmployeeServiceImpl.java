package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.EmployeeDao;
import com.group15.msm.repository.EmployeeRepository;
import com.group15.msm.service.serviceInterface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 09:07
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Optional<EmployeeDao> getEmployeeById(int id) {
        Optional<EmployeeDao> employeeDao = repository.findById(id);
        return employeeDao;
    }

    @Override
    public EmployeeDao setEmployee(EmployeeDao employeeDao) {
        return repository.save(employeeDao);
    }

}
