package com.spabbitecomm.common.inventory.model;

import com.spabbitecomm.common.model.Model;

import java.math.BigDecimal;

public class ProductModel extends Model {

	private String name;
	private Integer quantity;
	private BigDecimal unitPrice;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	    
}
