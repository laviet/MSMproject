package com.group15.msm.controllers;

import com.group15.msm.dao.InvoiceDetailDao;
import com.group15.msm.dao.InvoiceSaleDao;
import com.group15.msm.dao.MotorcycleDetailDao;
import com.group15.msm.message.response.DataResponse;
import com.group15.msm.model.ExportModel;
import com.group15.msm.service.MotorcycleDetail;
import com.group15.msm.service.serviceInterface.InvoiceDetailService;
import com.group15.msm.service.serviceInterface.InvoiceSaleService;
import com.group15.msm.service.serviceInterface.MotorcycleDetailService;
import com.group15.msm.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 10:23
 */
@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private InvoiceSaleService invoiceSaleService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;
    @Autowired
    private MotorcycleDetailService motorcycleService;
    @Autowired
    private MotorcycleDetail motorcycleDetail;

    @PostMapping("")
    @Transactional
    public ResponseEntity exportInvoice(@Valid @RequestBody ExportModel exportModel){

        InvoiceSaleDao invoiceSaleDao=new InvoiceSaleDao();
        InvoiceDetailDao invoiceDetailDao=new InvoiceDetailDao();

        BeanMapper.BeanCoppy(exportModel, invoiceSaleDao);

        invoiceDetailDao.setSanphamId(exportModel.getSanphamId());
        invoiceDetailDao.setSoluong(exportModel.getSoluong());
        invoiceDetailDao.setDongia(exportModel.getDongia());
        invoiceDetailDao.setHoadonbanhangId(exportModel.getId());

        invoiceSaleService.setInvoiceSale(invoiceSaleDao);
        InvoiceDetailDao detailDao= invoiceDetailService.setInvoiceDetail(invoiceDetailDao);
        return ResponseEntity.ok(detailDao.getId());
    }
    @PostMapping("/updateMotorcycle")
    public ResponseEntity updateDetailMotorcycle(@RequestBody MotorcycleDetailDao motorcycleDetailDao){
        MotorcycleDetailDao detailDao=motorcycleService.getMotorcycleById(motorcycleDetailDao.getId());
        detailDao.setChitiethoadonId(motorcycleDetailDao.getChitiethoadonId());
        motorcycleService.setMotorcycleDetial(detailDao);
        return ResponseEntity.ok("Thành công");
    }
    @GetMapping("/getImportDetail")
    public ResponseEntity getImportDetail(@RequestParam(name="id") String productId){
        List<MotorcycleDetailDao> motorList=motorcycleDetail.getMotorycycle(productId);
        return DataResponse.getData(motorList);
    }
}
