package com.spabbitecomm.order.command.producer;

import com.spabbitecomm.common.order.event.model.UserOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${spabbitecomm.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${spabbitecomm.rabbitmq.routingkey}")
	private String routingkey;

	public void produceUserOrderCreatedEvent(UserOrder userOrder){
		amqpTemplate.convertAndSend(exchange, routingkey, userOrder);
		System.out.println("Send msg = " + userOrder);
	}

}