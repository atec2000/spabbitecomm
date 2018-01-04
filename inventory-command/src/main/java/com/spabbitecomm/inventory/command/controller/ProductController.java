package com.spabbitecomm.inventory.command.controller;

import com.spabbitecomm.common.inventory.model.ProductModel;
import com.spabbitecomm.inventory.command.Model.Product;
import com.spabbitecomm.inventory.command.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
	
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product createUserOrder(@RequestBody Product product) {
        LOG.info(ProductModel.class.getSimpleName() + " request received");

        Product productCreated = productService.createProduct(product);

        return productCreated;
    }
        
}
