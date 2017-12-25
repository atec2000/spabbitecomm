package com.spabbitecomm.query.consumer;

import com.spabbitecomm.common.order.event.model.UserOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues="${jsa.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedUserOrderCreatedEvent(UserOrder userOrder) {
        System.out.println("Recieved UserOrderCreatedEvent: " + userOrder);
        System.out.println("order id: " + userOrder.getId());
    }

}