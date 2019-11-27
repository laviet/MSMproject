package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.SupplierDao;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 23-11-2019
 * Time: 16:24
 */
public interface SupplierService {
    Iterable<SupplierDao> getAllSupplier();
}
