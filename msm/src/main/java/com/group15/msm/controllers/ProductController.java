package com.group15.msm.controllers;

import com.group15.msm.dao.ProductDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.service.serviceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 15:05
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("")
    public ResponseEntity getAllProduct(){
        Iterable<ProductDao> productDaos=productService.getAllProduct();
        return DataResponse.getData(productDaos);
    }
}
