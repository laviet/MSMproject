package com.group15.msm.controllers;

import com.group15.msm.dao.SupplierDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.security.IsCustomer;
import com.group15.msm.service.serviceInterface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 23-11-2019
 * Time: 16:17
 */
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("")
    @IsCustomer
    public ResponseEntity getSupplier() {
        Iterable<SupplierDao> supplierDao = supplierService.getAllSupplier();
        return DataResponse.getData(supplierDao);
    }
}
