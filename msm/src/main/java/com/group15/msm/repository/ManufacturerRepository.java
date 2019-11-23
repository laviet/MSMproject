package com.group15.msm.repository;

import com.group15.msm.dao.ManufacturerDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 00:17
 */
@Repository
public interface ManufacturerRepository extends CrudRepository<ManufacturerDao,String> {

}
