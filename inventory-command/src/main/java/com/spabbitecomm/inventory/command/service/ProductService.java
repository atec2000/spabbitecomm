package com.spabbitecomm.inventory.command.service;

import com.spabbitecomm.inventory.command.Model.Product;
import com.spabbitecomm.inventory.command.producer.ProductCreatedMessageProducer;
import com.spabbitecomm.inventory.command.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCreatedMessageProducer productCreatedMessageProducer;

    public Product createProduct(Product product) {
        //String id = UUID.randomUUID().toString();
        //product.setId(id);
        Product productCreated = productRepository.save(product);

        /*
         * send message to RabbitMQ
         */
        productCreatedMessageProducer.produceProductCreatedMessage(product);

        return productCreated;
    }

}
