package com.example.jpetstore.service;

import java.util.List;

import com.example.jpetstore.domain.BiddingInfo;

public interface BiddingService {
	
	void insertBidding(BiddingInfo info);
	void updateCurrentMaxPrice(String itemId, int expectPrice);
	List<BiddinngInfo> getBiddingInfoList(String itemId, String userId);
	void insertSuccess(String itemId, String userId, String successBid, int price);

}
