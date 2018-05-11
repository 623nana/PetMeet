package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;

public interface ItemDao {

	public void updateQuantity(Order order) throws DataAccessException;
	
	boolean isItemInStock(String itemId) throws DataAccessException;
	
	List<Item> getItemListByProduct(String productId) throws DataAccessException;
	
	Item getItem(String itemId) throws DataAccessException;
	  
	void insertPost(Item item) throws DataAccessException;
	
	void insertAuction(AuctionItem item) throws DataAccessException;
	
	void updatePost(Item item) throws DataAccessException;
	
	void updateAuction(AuctionItem item) throws DataAccessException;
	
	void deletePost(Item item) throws DataAccessException;
	
	void deleteAuction(AuctionItem item) throws DataAccessException;

}
