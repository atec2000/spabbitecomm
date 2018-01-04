package com.spabbitecomm.order.command.mapper;

import com.spabbitecomm.common.model.UserOrderModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper {

	int insert(UserOrderModel userOrderModel);

}
