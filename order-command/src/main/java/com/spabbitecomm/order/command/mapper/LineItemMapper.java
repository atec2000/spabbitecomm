package com.spabbitecomm.order.command.mapper;

import com.spabbitecomm.common.order.event.model.LineItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LineItemMapper {

	int insert(LineItem lineItem);

}
