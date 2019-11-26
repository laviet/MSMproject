package com.group15.msm.repository;

import com.group15.msm.dao.InvoiceDetailDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 09:31
 */
@Repository
public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetailDao, Integer> {

}
