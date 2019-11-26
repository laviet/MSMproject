package com.group15.msm.repository;

import com.group15.msm.dao.ImportDetailDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 09:03
 */
@Repository
public interface ImportDetailRepository extends CrudRepository<ImportDetailDao, Integer> {
    Iterable<ImportDetailDao> getAllBySanphamId(String productId);
}
