package com.spabbitecomm.command.controller;

import com.spabbitecomm.command.producer.Producer;
import com.spabbitecomm.command.service.UserOrderService;
import com.spabbitecomm.common.order.event.model.UserOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

    @Autowired
    Producer producer;

    @Autowired
    UserOrderService userOrderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUserOrder(@RequestBody UserOrder userOrder) {
        LOG.debug(UserOrder.class.getSimpleName() + " request received");

        UserOrder userOrderCreated = userOrderService.createUserOrder(userOrder);

        /*
         * send message to RabbitMQ
         */
        producer.produceUserOrderCreatedEvent(userOrderCreated);

    }
        
}
