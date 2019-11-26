package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.InvoiceSaleDao;
import com.group15.msm.repository.InvoiceSaleRepository;
import com.group15.msm.service.serviceInterface.InvoiceSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 09:24
 */
@Service
public class InvoiceSaleServiceImpl implements InvoiceSaleService {
    @Autowired
    InvoiceSaleRepository repository;

    @Override
    public InvoiceSaleDao setInvoiceSale(InvoiceSaleDao saleDao) {
        return repository.save(saleDao);
    }
}
