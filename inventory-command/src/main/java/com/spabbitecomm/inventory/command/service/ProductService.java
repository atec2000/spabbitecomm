package com.spabbitecomm.inventory.command.service;

import com.spabbitecomm.common.model.LineItemModel;
import com.spabbitecomm.common.model.UserOrderModel;
import com.spabbitecomm.inventory.command.model.Product;
import com.spabbitecomm.inventory.command.producer.ProductCreatedMessageProducer;
import com.spabbitecomm.inventory.command.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private ProductCreatedMessageProducer productCreatedMessageProducer;

    @Value("${mongodb.collectionNames.product}")
    private String productCollectionName;

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

    @Transactional
    public void decreaseQuantity(UserOrderModel userOrderModel) {

        List<LineItemModel> lineItems = userOrderModel.getLineItems();
        for (LineItemModel lineItem : lineItems) {
            String productId = lineItem.getProductId();
            Integer quantity = lineItem.getQuantity();

            mongoOperations.findAndModify(
                    query(where("id").is(productId)),
                    new Update().inc("quantity", -quantity),
                    options().returnNew(true),
                    Product.class);
        }
    }

}
