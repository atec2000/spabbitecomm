package com.spabbitecomm.order.command.producer;

import com.spabbitecomm.common.model.UserOrderModel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedMessageProducer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${spabbitecomm.rabbitmq.orderExchange}")
	private String orderExchange;
	
	@Value("${spabbitecomm.rabbitmq.orderCreatedRoutingKey}")
	private String orderCreatedRoutingKey;

	public void produceUserOrderCreatedMessage(UserOrderModel userOrderModel){
		amqpTemplate.convertAndSend(orderExchange, orderCreatedRoutingKey, userOrderModel);
		System.out.println("Send msg for " + UserOrderModel.class.getSimpleName() + ", id: " + userOrderModel.getId());
	}

}