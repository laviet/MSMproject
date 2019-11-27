package com.group15.msm.service.serviceImpl;

import com.group15.msm.dao.ProductDao;
import com.group15.msm.repository.ProductRepository;
import com.group15.msm.service.serviceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 24-11-2019
 * Time: 15:04
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public Iterable<ProductDao> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public Iterable<ProductDao> getAllProductSort(String category) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, category));
    }

    @Override
    public Iterable<ProductDao> getAllByName(String name) {
        return repository.getAllByTensanphamContains(name);
    }
}
