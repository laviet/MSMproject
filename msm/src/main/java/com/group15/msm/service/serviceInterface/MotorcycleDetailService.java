package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.MotorcycleDetailDao;

import java.util.List;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:35
 */
public interface MotorcycleDetailService {
    MotorcycleDetailDao getMotorcycleById(int id);
    MotorcycleDetailDao setMotorcycleDetial(MotorcycleDetailDao motorcycleDetailDao);
    List<MotorcycleDetailDao> getMotorcycleByImportDetialId(int id);
}
