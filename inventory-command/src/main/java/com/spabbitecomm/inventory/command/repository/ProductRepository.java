package com.spabbitecomm.inventory.command.repository;

import com.spabbitecomm.common.inventory.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {

}
