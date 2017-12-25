package com.spabbitecomm.command.service;

import com.spabbitecomm.common.order.event.model.UserOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jack on 12/25/17.
 */
@Service
public class UserOrderService {

    public UserOrder createUserOrder(UserOrder userOrder) {
        String id = UUID.randomUUID().toString();
        userOrder.setId(id);

        return userOrder;
    }
}
