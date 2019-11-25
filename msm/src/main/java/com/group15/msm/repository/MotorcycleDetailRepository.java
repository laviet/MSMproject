package com.group15.msm.repository;

import com.group15.msm.dao.MotorcycleDetailDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:34
 */
@Repository
public interface MotorcycleDetailRepository extends CrudRepository<MotorcycleDetailDao, Integer> {

}
