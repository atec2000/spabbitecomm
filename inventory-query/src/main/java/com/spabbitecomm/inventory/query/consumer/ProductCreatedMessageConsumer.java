package com.spabbitecomm.inventory.query.consumer;

import com.spabbitecomm.inventory.query.model.Product;
import com.spabbitecomm.inventory.query.service.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedMessageConsumer {

    @Autowired
    private ProductService productService;

    @RabbitListener(queues="${spabbitecomm.rabbitmq.productCreatedQueue}", containerFactory="rabbitListenerContainerFactory")
    public void recievedProductCreatedMessage(Product product) {
        System.out.println("Recieved msg for " + Product.class.getSimpleName() + ", id: " + product.getId());

        // Create product document for search
        productService.save(product);
    }

}