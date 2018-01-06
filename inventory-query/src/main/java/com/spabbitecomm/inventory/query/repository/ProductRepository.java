package com.spabbitecomm.inventory.query.repository;

import com.spabbitecomm.inventory.query.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    Page<Product> findByName(String Name, Pageable pageable);

}
