package com.group15.msm.controllers;

import com.group15.msm.dao.ManufacturerDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.service.serviceInterface.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 00:21
 */
@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {
    @Autowired
    ManufacturerService manufacturerService;
    @GetMapping("")
    public ResponseEntity getManufacturer(){
        Iterable<ManufacturerDao> manufacturerDaos=manufacturerService.getAllManufacturer();
        return DataResponse.getData(manufacturerDaos);
    }
}
