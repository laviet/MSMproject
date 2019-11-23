package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.ManufacturerDao;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 00:18
 */
public interface ManufacturerService {
    Iterable<ManufacturerDao> getAllManufacturer();
}
