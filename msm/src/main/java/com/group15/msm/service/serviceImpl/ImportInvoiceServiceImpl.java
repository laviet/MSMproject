package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.ImportInvoiceDao;
import com.group15.msm.repository.ImportInvoiceRepository;
import com.group15.msm.service.serviceInterface.ImportInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 08:58
 */
@Service
public class ImportInvoiceServiceImpl implements ImportInvoiceService {

    @Autowired
    ImportInvoiceRepository repository;

    @Override
    public ImportInvoiceDao setImportInvoice(ImportInvoiceDao invoiceDao) {
        return repository.save(invoiceDao);
    }
}
