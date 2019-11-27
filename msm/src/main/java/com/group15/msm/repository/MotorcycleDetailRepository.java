package com.group15.msm.repository;

import com.group15.msm.dao.MotorcycleDetailDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:34
 */
@Repository
public interface MotorcycleDetailRepository extends CrudRepository<MotorcycleDetailDao, Integer> {
    List<MotorcycleDetailDao> getByChitietnhapId(int id);

    @Query(value = "SELECT COUNT(id) FROM chitietxe WHERE chitiethoadon_id!=''", nativeQuery = true)
    int getCountSaled();
}
