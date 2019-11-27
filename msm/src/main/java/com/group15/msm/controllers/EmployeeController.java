package com.group15.msm.controllers;

import com.group15.msm.dao.EmployeeDao;
import com.group15.msm.dao.UserDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.model.EmployeeModel;
import com.group15.msm.security.CurrentUser;
import com.group15.msm.security.service.UserPrinciple;
import com.group15.msm.service.serviceInterface.EmployeeService;
import com.group15.msm.service.serviceInterface.UserLoginService;
import com.group15.msm.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 20-11-2019
 * Time: 23:39
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("")
    public ResponseEntity getEmployee(@CurrentUser UserPrinciple userPrinciple) {
        Optional<EmployeeDao> employeeDao = employeeService.getEmployeeById(userPrinciple.getId().intValue());
        EmployeeModel employeeModel = new EmployeeModel();
        if (employeeDao.isPresent()) {
            BeanMapper.BeanCoppy(employeeDao.get(), employeeModel);
        } else {
            employeeModel.setManhanvien(userPrinciple.getId().intValue());
            employeeModel.setEmail(userPrinciple.getEmail());
            employeeModel.setTennhanvien(userPrinciple.getName());
        }
        return DataResponse.getData(employeeModel);
    }

    @GetMapping("/employees")
    public ResponseEntity getAllEmployee() {
        Iterable<EmployeeDao> employeeDaos = employeeService.getAllEmployee();
        return DataResponse.getData(employeeDaos);
    }

    @Transactional
    @PostMapping("/updateEmployee")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeModel employeeModel) {
        Optional<UserDao> userDao = userLoginService.getUserById(employeeModel.getManhanvien());
        EmployeeDao employeeDao = new EmployeeDao();
        UserDao userDaoUpdate = new UserDao();
        if (userDao.isPresent()) {
            BeanMapper.BeanCoppy(employeeModel, employeeDao);
            employeeDao.setThoigiancapnhat(new Date());
            EmployeeDao employeeDaoUpdate = employeeService.setEmployee(employeeDao);

            userDaoUpdate.setId(employeeDaoUpdate.getManhanvien());
            userDaoUpdate.setEmail(employeeDaoUpdate.getEmail());
            userDaoUpdate.setName(employeeDaoUpdate.getTennhanvien());
            userLoginService.updateUser(userDaoUpdate);

            return ResponseEntity.ok().body("Cập nhật nhân viên thành công");
        }
        return ResponseEntity.ok().body("Cập nhật nhân viên thất bại");
    }
}
