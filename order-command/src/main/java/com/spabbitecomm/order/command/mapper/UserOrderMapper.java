package com.spabbitecomm.order.command.mapper;

import com.spabbitecomm.common.order.event.model.UserOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper {

	int insert(UserOrder userOrder);

}
