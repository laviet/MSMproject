package com.group15.msm.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.group15.msm.dao.ImportDetailDao;
import com.group15.msm.dao.ImportInvoiceDao;
import com.group15.msm.dao.MotorcycleDetailDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.model.ImportModel;
import com.group15.msm.model.MotorcycleDetailModel;
import com.group15.msm.service.serviceInterface.ImportDetailService;
import com.group15.msm.service.serviceInterface.ImportInvoiceService;
import com.group15.msm.service.serviceInterface.MotorcycleService;
import com.group15.msm.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 14:08
 */
@RestController
@RequestMapping("/api/import")
public class ImportController {
    @Autowired
    ImportInvoiceService importInvoiceService;
    @Autowired
    ImportDetailService importDetailService;
    @Autowired
    MotorcycleService motorcycleService;

    @PostMapping("")
    @Transactional
    public ResponseEntity importInvoice(@Valid @RequestBody ImportModel importModel) {

        ImportInvoiceDao importInvoiceDao=new ImportInvoiceDao();
        ImportDetailDao importDetailDao=new ImportDetailDao();

        BeanMapper.BeanCoppy(importModel, importInvoiceDao);

        importDetailDao.setSanphamId(importModel.getSanphamId());
        importDetailDao.setSoluong(importModel.getSoluong());
        importDetailDao.setDongia(importModel.getDongia());
        importDetailDao.setHoadonnhapId(importModel.getId());

        importInvoiceService.setImportInvoice(importInvoiceDao);
       ImportDetailDao detailDao= importDetailService.setImportDetail(importDetailDao);
        System.out.println("vaoi day: "+detailDao.getId());
        return ResponseEntity.ok(detailDao.getId());
    }
    @PostMapping("/motorcycleDetail")
    public ResponseEntity setMotorcycleDetail(@Valid @RequestBody MotorcycleDetailModel motorcycleDetailModel){
        System.out.println(motorcycleDetailModel.getSokhung()+motorcycleDetailModel.getSomay()+motorcycleDetailModel.getChitietnhapId()+motorcycleDetailModel.getChitiethoadonId());
        MotorcycleDetailDao motorcycleDetailDao=new MotorcycleDetailDao();
        BeanMapper.BeanCoppy(motorcycleDetailModel, motorcycleDetailDao);
        motorcycleService.setMotorcycleDetial(motorcycleDetailDao);
        return ResponseEntity.ok("Thành công");
    }
}
