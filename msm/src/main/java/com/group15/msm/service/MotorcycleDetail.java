package com.group15.msm.service;

import com.group15.msm.dao.ImportDetailDao;
import com.group15.msm.dao.MotorcycleDetailDao;
import com.group15.msm.service.serviceInterface.ImportDetailService;
import com.group15.msm.service.serviceInterface.MotorcycleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 12:35
 */
@Component
public class MotorcycleDetail {
    @Autowired
    private ImportDetailService importDetailService;
    @Autowired
    private MotorcycleDetailService motorcycleDetailService;

    public List<MotorcycleDetailDao> getMotorycycle(String productId){

        List<MotorcycleDetailDao> motorcycleList=new ArrayList<MotorcycleDetailDao>();

        Iterable<ImportDetailDao> importDetails=importDetailService.getAllByProductId(productId);
        for (ImportDetailDao dao: importDetails) {
            List<MotorcycleDetailDao> motor=motorcycleDetailService.getMotorcycleByImportDetialId(dao.getId());
            for (MotorcycleDetailDao m: motor) {
                motorcycleList.add(m);
            }
        }
        return motorcycleList;
    }

}
