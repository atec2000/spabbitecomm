package com.spabbitecomm.inventory.query.model;

import com.spabbitecomm.common.inventory.model.ProductModel;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

@Document(indexName = "product", type = "generic")
public class Product extends ProductModel {

}
