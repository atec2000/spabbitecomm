package com.spabbitecomm.order.command.service;

import com.spabbitecomm.common.model.LineItemModel;
import com.spabbitecomm.common.model.UserOrderModel;
import com.spabbitecomm.order.command.mapper.LineItemMapper;
import com.spabbitecomm.order.command.mapper.UserOrderMapper;
import com.spabbitecomm.order.command.producer.OrderCreatedMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private LineItemMapper lineItemMapper;

    @Autowired
    OrderCreatedMessageProducer orderCreatedMessageProducer;

    public UserOrderModel createUserOrder(UserOrderModel userOrderModel) {
        String id = UUID.randomUUID().toString();
        userOrderModel.setId(id);
        userOrderMapper.insert(userOrderModel);

        for (LineItemModel lineItem : userOrderModel.getLineItems()) {
            String lineItemId = UUID.randomUUID().toString();
            lineItem.setId(lineItemId);
            lineItem.setUserOrderId(id);
            lineItemMapper.insert(lineItem);
        }

        /*
         * send message to RabbitMQ
         */
        orderCreatedMessageProducer.produceUserOrderCreatedMessage(userOrderModel);

        return userOrderModel;
    }

}
