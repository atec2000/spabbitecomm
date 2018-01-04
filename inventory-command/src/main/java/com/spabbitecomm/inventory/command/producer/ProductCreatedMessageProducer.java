package com.spabbitecomm.inventory.command.producer;

import com.spabbitecomm.common.inventory.model.ProductModel;
import com.spabbitecomm.inventory.command.Model.Product;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedMessageProducer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${spabbitecomm.rabbitmq.productExchange}")
	private String productExchange;
	
	@Value("${spabbitecomm.rabbitmq.productCreatedRoutingKey}")
	private String productCreatedRoutingKey;

	public void produceProductCreatedMessage(Product product){
		amqpTemplate.convertAndSend(productExchange, productCreatedRoutingKey, product);
		System.out.println("Send msg for " + Product.class.getSimpleName() + ", id: " + product.getId());
	}

}