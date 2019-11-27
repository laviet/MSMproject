package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.InvoiceDetailDao;
import com.group15.msm.repository.InvoiceDetailRepository;
import com.group15.msm.service.serviceInterface.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 09:33
 */
@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    @Autowired
    InvoiceDetailRepository repository;

    @Override
    public InvoiceDetailDao setInvoiceDetail(InvoiceDetailDao detailDao) {
        return repository.save(detailDao);
    }
}
