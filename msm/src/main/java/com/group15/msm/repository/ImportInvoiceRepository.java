package com.group15.msm.repository;

import com.group15.msm.dao.ImportInvoiceDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 25-11-2019
 * Time: 08:56
 */
@Repository
public interface ImportInvoiceRepository extends CrudRepository<ImportInvoiceDao, String> {

}
