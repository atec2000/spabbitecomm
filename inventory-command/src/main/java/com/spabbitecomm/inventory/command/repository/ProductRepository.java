package com.spabbitecomm.inventory.command.repository;

import com.spabbitecomm.inventory.command.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
