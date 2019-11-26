package com.group15.msm.service.serviceInterface;

import com.group15.msm.dao.ProductDao;
import org.springframework.data.domain.Sort;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 15:03
 */
public interface ProductService {
    Iterable<ProductDao> getAllProduct();
    Iterable<ProductDao> getAllProductSort(String category);
    Iterable<ProductDao> getAllByName(String name);
}
