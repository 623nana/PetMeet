package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;

public interface SearchDao {

	List<Product> searchProductList(String keywords, String option) throws DataAccessException;
	
	List<Item> searchItemList(String keywords, String option) throws DataAccessException;
}
