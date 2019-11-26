package com.group15.msm.repository;

import com.group15.msm.dao.InvoiceSaleDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 26-11-2019
 * Time: 09:22
 */
@Repository
public interface InvoiceSaleRepository extends CrudRepository<InvoiceSaleDao, String> {

}
