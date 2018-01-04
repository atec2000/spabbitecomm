package com.spabbitecomm.common.model;

import java.util.List;

public class UserOrderModel extends Model {

	private static final long serialVersionUID = -5017075322968712692L;
	
	private String comment;

	private List<LineItemModel> lineItems;

    public UserOrderModel() {
    }

    public UserOrderModel(String id, String comment, List<LineItemModel> lineItems) {
		super(id);
        this.comment = comment;
        this.lineItems = lineItems;
    }
  
	public String getComment() {
		return comment;
	}

	public List<LineItemModel> getLineItems() {
		return lineItems;
	}

}
