package com.spabbitecomm.inventory.command.consumer;

import com.spabbitecomm.common.model.UserOrderModel;
import com.spabbitecomm.inventory.command.service.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedMessageConsumer {

    @Autowired
    private ProductService productService;

    @RabbitListener(queues="${spabbitecomm.rabbitmq.orderCreatedQueue}", containerFactory="rabbitListenerContainerFactory")
    public void recievedUserOrderCreatedMessage(UserOrderModel userOrderModel) {
        System.out.println("Recieved msg for " + UserOrderModel.class.getSimpleName() + ", id: " + userOrderModel.getId());

        // Deduct quantity from product
        productService.decreaseQuantity(userOrderModel);
    }

}