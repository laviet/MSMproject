package com.group15.msm.repository;

import com.group15.msm.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 15:01
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductDao, String> {
    Iterable<ProductDao> getAllByTensanphamContains(String name);

}
