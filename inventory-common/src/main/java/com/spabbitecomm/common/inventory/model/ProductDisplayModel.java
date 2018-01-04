package com.spabbitecomm.common.inventory.model;

import com.spabbitecomm.common.model.Model;

import java.util.List;

public class ProductDisplayModel extends Model {

	private static final long serialVersionUID = -5017075322968712692L;
	
	private String name;

	private List<ProductModel> productModels;

    public ProductDisplayModel() {
    }

    public ProductDisplayModel(String id, String name, List<ProductModel> productModels) {
		super(id);
        this.name = name;
        this.productModels = productModels;
    }

	public String getName() {
		return name;
	}

	public List<ProductModel> getProductModels() {
		return productModels;
	}

}
