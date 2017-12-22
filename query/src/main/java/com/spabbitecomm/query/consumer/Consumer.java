package com.spabbitecomm.query.consumer;

import com.spabbitecomm.common.event.model.Company;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@RabbitListener(queues="${jsa.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Company company) {
        System.out.println("Recieved Message: " + company);
    }

}