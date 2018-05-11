package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface BiddingDao {
	void insertBidding(BiddingInfo info) throws DataAccessException;

//	void updateBidding(BiddingInfo info) throws DataAccessException;

	void insertSuccess(String itemId, String userId, String successBid, int price) throws DataAccessException;
	
	//AuctionItem의 currentPrice를 갱신하는데 이것은 현재 최고 가격을 보여주기 위해 필요하다.
	void updateCurrentMaxPrice(String itemId, int expectPrice) throws DataAccessException;
	
	List<BiddingInfo> getBiddingInfoList(String itemId, String userId) throws DataAccessException;
}
