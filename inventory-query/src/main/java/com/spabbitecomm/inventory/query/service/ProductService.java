package com.spabbitecomm.inventory.query.service;

import com.spabbitecomm.inventory.query.model.Product;
import com.spabbitecomm.inventory.query.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findByName(String name, PageRequest pageRequest) {
        return productRepository.findByName(name, pageRequest);
    }

}
