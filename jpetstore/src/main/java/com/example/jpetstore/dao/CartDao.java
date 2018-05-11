package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Item;

public interface CartDao {

	void insertCartItem(Item item) throws DataAccessException;
	
	void deleteCartItem(Item item) throws DataAccessException;
}
