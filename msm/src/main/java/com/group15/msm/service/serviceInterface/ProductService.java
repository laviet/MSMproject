package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.ProductDao;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 15:03
 */
public interface ProductService {
    Iterable<ProductDao> getAllProduct();
}
