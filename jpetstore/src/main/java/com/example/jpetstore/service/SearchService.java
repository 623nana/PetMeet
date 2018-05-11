package com.example.jpetstore.service;

import java.util.List;

import com.example.jpetstore.domain.Product;
import com.example.jpetstore.domain.Item;

public interface SearchService {
	List<Product> searchProductList(String keywords, String option);
	
	
	List<Item> searchItemList(String keywords, String option);
}
