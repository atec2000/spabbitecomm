package com.spabbitecomm.order.query.consumer;

import com.spabbitecomm.common.order.event.model.UserOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues="${spabbitecomm.rabbitmq.queue}", containerFactory="rabbitListenerContainerFactory")
    public void recievedUserOrderCreatedEvent(UserOrder userOrder) {
        System.out.println("Recieved UserOrderCreatedEvent: order id: " + userOrder.getId());
    }

}