package com.spabbitecomm.order.command.service;

import com.spabbitecomm.common.order.event.model.LineItem;
import com.spabbitecomm.common.order.event.model.UserOrder;
import com.spabbitecomm.order.command.mapper.LineItemMapper;
import com.spabbitecomm.order.command.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private LineItemMapper lineItemMapper;

    public UserOrder createUserOrder(UserOrder userOrder) {
        String id = UUID.randomUUID().toString();
        userOrder.setId(id);
        userOrderMapper.insert(userOrder);

        for (LineItem lineItem : userOrder.getLineItems()) {
            String lineItemId = UUID.randomUUID().toString();
            lineItem.setId(lineItemId);
            lineItem.setUserOrderId(id);
            lineItemMapper.insert(lineItem);
        }

        return userOrder;
    }

}
