package com.group15.msm.controllers;

import com.group15.msm.model.ImportModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("")
    public ResponseEntity importInvoice(@Valid @RequestBody ImportModel importModel) {
        System.out.println("dau "+importModel.getId() + importModel.getNhacungcapId() +
                importModel.getNgaynhap() + importModel.getNhanvienId());
        System.out.println("sau: "+importModel.getSanphamId()+importModel.getSoluong()+importModel.getDongia());
        return ResponseEntity.ok("thanh cong");
    }
}
