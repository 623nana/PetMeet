package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;

public interface ItemDao {

  public void updateQuantity(Order order) throws DataAccessException;

  boolean isItemInStock(String itemId) throws DataAccessException;

  List<Item> getItemListByProduct(String productId) throws DataAccessException;

  List<Item> getItemListByCategory(String categoryId) throws DataAccessException;
  
  Item getItem(String itemId) throws DataAccessException;
  
  void insertFixedItem(Item item) throws DataAccessException;
  
  String setProductId(String name) throws DataAccessException;
  
  void insertNewProduct(Item item) throws DataAccessException;
  
  void updateFixedItem(Item item) throws DataAccessException;
  
  void insertAuctionItem(Item item) throws DataAccessException;
  
  void insertAuctionInfo(AuctionItem auctionItem) throws DataAccessException;
  
  AuctionItem getAuctionItem(String itemId) throws DataAccessException;
  
  void updateAuctionItem(Item item) throws DataAccessException; 
  
  void insertBid(BiddingInfo biddingInfo) throws DataAccessException;

  void insertInventory(Item item) throws DataAccessException;


}