package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.ImportDetailDao;
import com.group15.msm.repository.ImportDetailRepository;
import com.group15.msm.service.serviceInterface.ImportDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:04
 */
@Service
public class ImportDetailServiceImpl implements ImportDetailService {
    @Autowired
    ImportDetailRepository repository;

    @Override
    public ImportDetailDao setImportDetail(ImportDetailDao detailDao) {
        return repository.save(detailDao);
    }

    @Override
    public Iterable<ImportDetailDao> getAllByProductId(String productId) {
        return repository.getAllBySanphamId(productId);
    }
}
