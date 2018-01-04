package com.spabbitecomm.order.command.mapper;

import com.spabbitecomm.common.model.LineItemModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LineItemMapper {

	int insert(LineItemModel lineItem);

}
