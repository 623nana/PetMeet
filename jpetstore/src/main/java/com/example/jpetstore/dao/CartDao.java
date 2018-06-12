package com.example.jpetstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Item;

public interface CartDao {

	void insertCartItem(@Param("item")Item item, @Param("username")String username, @Param("qty")int qty) throws DataAccessException;
	
	void deleteCartItemByUsername(String username) throws DataAccessException;
	
	List<String> getCartItemByUsername(String username) throws DataAccessException;
	
	void updateCartQty(@Param("item")Item item, @Param("qty")int qty) throws DataAccessException;
	
	void updateCartOneQty(@Param("itemId")String itemId, @Param("username")String username) throws DataAccessException;
	
	int getQtyByItem(Item item) throws DataAccessException;
	
	void deleteCartItemByItem(Item item) throws DataAccessException;

}
