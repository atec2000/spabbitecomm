package com.spabbitecomm.inventory.command.model;

import com.spabbitecomm.common.inventory.model.ProductModel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product extends ProductModel {

}
