package com.example.jpetstore.dao.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.ItemDao;
import com.example.jpetstore.dao.mybatis.mapper.CartMapper;
import com.example.jpetstore.dao.mybatis.mapper.ItemMapper;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.HotItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;

@Repository
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private CartMapper cartMapper;
	
	public void updateQuantity(Order order) throws DataAccessException {
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem lineItem = (LineItem) order.getLineItems().get(i);
			String itemId = lineItem.getItemId();
			Integer increment = new Integer(lineItem.getQuantity());
			Map<String, Object> param = new HashMap<String, Object>(2);
			param.put("itemId", itemId);
			param.put("increment", increment);
			itemMapper.updateInventoryQuantity(param);
		}
	}

	public boolean isItemInStock(String itemId) throws DataAccessException {
		return (itemMapper.getInventoryQuantity(itemId) > 0);
	}

	public List<Item> getItemListByProduct(String productId) 
			throws DataAccessException {
		return itemMapper.getItemListByProduct(productId);
	}

	public List<Item> getItemListByCategory(String categoryId) 
			throws DataAccessException {
		return itemMapper.getItemListByCategory(categoryId);
		
	}
	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}
	
	public void insertFixedItem(Item item) throws DataAccessException {
		itemMapper.insertFixedItem(item);
	}
	
	public String setProductId(String name) throws DataAccessException {
		return itemMapper.setProductId(name);
	}
	
	public void insertNewProduct(Item item) throws DataAccessException {
		itemMapper.insertNewProduct(item);
	}

	@Override
	public void insertInventory(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.insertInventory(item);
	}
	
	public void updateFixedItem(Item item) throws DataAccessException{
		itemMapper.updateFixedItem(item);
	}
	
	public void insertAuctionItem(Item item) throws DataAccessException{
		itemMapper.insertAuctionItem(item);
	}
	
	public void insertAuctionInfo(AuctionItem auctionItem) throws DataAccessException{
		itemMapper.insertAuctionInfo(auctionItem);
	}
	
	public AuctionItem getAuctionItem(String itemId) throws DataAccessException {
		return itemMapper.getAuctionItem(itemId);
	}
	
	public void updateAuctionItem(Item item) throws DataAccessException{
		itemMapper.updateAuctionItem(item);
	}
	
	public void insertBid(BiddingInfo biddingInfo) throws DataAccessException{
		itemMapper.insertBid(biddingInfo);
	}
	
	public void insertNewEvent(AuctionItem auctionItem) {
		itemMapper.insertNewEvent(auctionItem);
	}

	public void updateCurrentMaxPrice(BiddingInfo biddingInfo) throws DataAccessException{
		itemMapper.updateCurrentMaxPrice(biddingInfo);
	}
	public void closeEvent(Date curTime) {
		itemMapper.closeEvent(curTime);		
	}
	
	public void updateItemPrice(BiddingInfo biddingInfo) {
		itemMapper.updateItemPrice(biddingInfo);
	}
	
	public void updateStatus(String itemId) {
		itemMapper.updateStatus(itemId);
	}
	
	public   void updateCloseTime(@Param("auctionTime")String auctionTime, @Param("itemId")String itemId) {
		itemMapper.updateCloseTime(auctionTime, itemId);
	}
	
	public BiddingInfo getSuccessBidder(String itemId) throws DataAccessException{
		return itemMapper.getSuccessBidder(itemId);
	}
	
	public void insertSuccessBidder(BiddingInfo biddingInfo) throws DataAccessException{
		itemMapper.insertSuccessBidder(biddingInfo);
	}
	
	public List<BiddingInfo> getBidListByItem(String itemId){
		return itemMapper.getBidListByItem(itemId);
	}
	
	public List<HotItem> getTopAuction(){
		return itemMapper.getTopAuction();
	}

	public List<Item> getItemListBySpecies(String species)
			throws DataAccessException {
		return itemMapper.getItemListBySpecies(species);
	}
	
	public List<Item> getItemListByUserId(String uesrId)
			throws DataAccessException {
		return itemMapper.getItemListByUserId(uesrId);
	}

	@Override
	public void deleteMyItem(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.deleteMyItem(itemId);
		cartMapper.deleteCartItemByItemId(itemId);

	}
	
	public List<Item> getMyPosting(String userId)
			throws DataAccessException {
		return itemMapper.getMyPosting(userId);
	}
	
	public List<BiddingInfo> getMyBidding(String username)
			throws DataAccessException {
		return itemMapper.getMyBidding(username);
	}

}