package com.group15.msm.controllers;

import com.group15.msm.message.response.DataResponse;
import com.group15.msm.security.IsAdmin;
import com.group15.msm.service.serviceInterface.MotorcycleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 27-11-2019
 * Time: 08:15
 */
@RestController
@RequestMapping("/api/statistic")
public class MotorcycleDetailController {
    @Autowired
    private MotorcycleDetailService motorcycleDetailService;

    @GetMapping("/saled")
    @IsAdmin
    public ResponseEntity statistic() {
        Integer saled = motorcycleDetailService.getCountSaled();
        return DataResponse.getData(saled);
    }

    @GetMapping("/remain")
    @IsAdmin
    public ResponseEntity countAll() {
        Long all = motorcycleDetailService.getAllCount();
        Long remain = all - motorcycleDetailService.getCountSaled();
        return DataResponse.getData(remain);
    }
}
