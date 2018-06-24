/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.jpetstore.dao.mybatis.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.HotItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;

/**
 * @author Eduardo Macarron
 *
 */
public interface ItemMapper {

  void updateInventoryQuantity(Map<String, Object> param);

  int getInventoryQuantity(String itemId);

  List<Item> getItemListByProduct(String productId);

  List<Item> getItemListByCategory(String categoryId);
  
  List<BiddingInfo> getBidListByItem(String itemId);
  
  void updateItemPrice(BiddingInfo biddingInfo);
  
  void updateStatus(String itemId);
  
  void updateCloseTime(@Param("auctionTime")String auctionTime, @Param("itemId")String itemId);
  
  List<HotItem> getTopAuction();
  
  void updateCurrentMaxPrice(BiddingInfo biddingInfo);
  
  void insertSuccessBidder(BiddingInfo biddingInfo);
  
  BiddingInfo getSuccessBidder(String itemId);
  
  Item getItem(String itemId);
  
  boolean isItemInStock(String itemId);
  
  void insertFixedItem(Item item);
  
  String setProductId(String name);
  
  void insertNewProduct(Item item);
  
  void updateFixedItem(Item item);
  
  void insertAuctionItem(Item item);
  
  void insertAuctionInfo(AuctionItem auctionItem);
  
  AuctionItem getAuctionItem(String itemId);
  
  void updateAuctionItem(Item item);

  void insertBid(BiddingInfo biddingInfo);

  void insertInventory(Item item);
  
  void insertNewEvent(AuctionItem auctionItem);
  void closeEvent(Date curTime);


}