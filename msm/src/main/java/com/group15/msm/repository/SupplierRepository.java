package com.group15.msm.repository;

import com.group15.msm.dao.SupplierDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 23-11-2019
 * Time: 16:23
 */
@Repository
public interface SupplierRepository extends CrudRepository<SupplierDao, String> {

}
