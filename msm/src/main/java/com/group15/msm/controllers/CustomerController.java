package com.group15.msm.controllers;

import com.group15.msm.dao.CustomerDao;
import com.group15.msm.dao.EmployeeDao;
import com.group15.msm.dao.UserDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.model.CustomerModel;
import com.group15.msm.model.EmployeeModel;
import com.group15.msm.security.CurrentUser;
import com.group15.msm.security.service.UserPrinciple;
import com.group15.msm.service.serviceInterface.CustomerService;
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
 * Create date: 22-11-2019
 * Time: 09:59
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/customers")
    public ResponseEntity getAllEmployee(){
        Iterable<CustomerDao> customerDaos=customerService.getAllCustomer();
        return DataResponse.getData(customerDaos);
    }
    @GetMapping("")
    public ResponseEntity getECustomer(@CurrentUser UserPrinciple userPrinciple) {
        Optional<CustomerDao> customerDao = customerService.getCutomerById(userPrinciple.getId().intValue());
        CustomerModel customerModel = new CustomerModel();
        if (customerDao.isPresent()) {
            BeanMapper.BeanCoppy(customerDao.get(), customerModel);
        } else {
            customerModel.setMakhachhang(userPrinciple.getId().intValue());
            customerModel.setEmail(userPrinciple.getEmail());
            customerModel.setTenkhachhang(userPrinciple.getName());
        }
        return DataResponse.getData(customerModel);
    }

    @Transactional
    @PostMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@Valid @RequestBody CustomerModel customerModel) {
        Optional<UserDao> userDao = userLoginService.getUserById(customerModel.getMakhachhang());
        CustomerDao customerDao = new CustomerDao();
        UserDao userDaoUpdate = new UserDao();
        if (userDao.isPresent()) {
            BeanMapper.BeanCoppy(customerModel, customerDao);
            customerDao.setThoigiancapnhat(new Date());
            CustomerDao customerDaoUpdate = customerService.setCustomer(customerDao);

            userDaoUpdate.setId(customerDaoUpdate.getMakhachhang());
            userDaoUpdate.setEmail(customerDaoUpdate.getEmail());
            userDaoUpdate.setName(customerDaoUpdate.getTenkhachhang());

            userLoginService.updateUser(userDaoUpdate);

            return ResponseEntity.ok().body("Cập nhật khách hàng thành công");
        }
        return ResponseEntity.ok().body("Cập nhật khách hàng thất bại");
    }
}
