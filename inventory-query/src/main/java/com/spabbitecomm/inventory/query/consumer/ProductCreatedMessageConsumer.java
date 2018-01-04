package com.spabbitecomm.inventory.query.consumer;

import com.spabbitecomm.common.inventory.model.ProductModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedMessageConsumer {

    @RabbitListener(queues="${spabbitecomm.rabbitmq.productCreatedQueue}", containerFactory="rabbitListenerContainerFactory")
    public void recievedProductCreatedMessage(ProductModel productModel) {
        System.out.println("Recieved msg for " + ProductModel.class.getSimpleName() + ", id: " + productModel.getId());
        // Deduct quantity from productModel
    }

}