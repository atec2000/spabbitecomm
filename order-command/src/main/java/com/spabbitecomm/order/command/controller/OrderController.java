package com.spabbitecomm.order.command.controller;

import com.spabbitecomm.order.command.service.UserOrderService;
import com.spabbitecomm.common.model.UserOrderModel;
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
public class OrderController {
	
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    UserOrderService userOrderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserOrderModel createUserOrder(@RequestBody UserOrderModel userOrderModel) {
        LOG.info(UserOrderModel.class.getSimpleName() + " request received");

        UserOrderModel userOrderModelCreated = userOrderService.createUserOrder(userOrderModel);

        return userOrderModelCreated;
    }
        
}
