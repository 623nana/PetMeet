package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface BiddingDao {
	void insertBidding(BiddingInfo info) throws DataAccessException;

//	void updateBidding(BiddingInfo info) throws DataAccessException;

	void insertSuccess(String itemId, String userId, String successBid, int price) throws DataAccessException;
	
	//AuctionItem�� currentPrice�� �����ϴµ� �̰��� ���� �ְ� ������ �����ֱ� ���� �ʿ��ϴ�.
	void updateCurrentMaxPrice(String itemId, int expectPrice) throws DataAccessException;
	
	List<BiddingInfo> getBiddingInfoList(String itemId, String userId) throws DataAccessException;
}
