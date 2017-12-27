package com.spabbitecomm.common.order.event.model;

import java.util.List;

public class UserOrder extends Model {

	private static final long serialVersionUID = -5017075322968712692L;
	
	private String name;

	private List<LineItem> lineItems;

    public UserOrder() {
    }

    public UserOrder(String id, String name, List<LineItem> lineItems) {
		super(id);
        this.name = name;
        this.lineItems = lineItems;
    }
  
	public String getName() {
		return name;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

}
