package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.BiddingDao;

@Service("BiddingServiceImpl")
public class BiddingServiceImpl implements BiddingService {
	
	@Autowired
	private BiddingDao biddingDao;

	@Override
	public void insertBidding(BiddingInfo info) {
		// TODO Auto-generated method stub
		biddingDao.insertBidding(info);
	}

	@Override
	public void updateCurrentMaxPrice(String itemId, int expectPrice) {
		// TODO Auto-generated method stub
		biddingDao.updateCurrentMaxPrice(itemId, expectPrice);
	}

	@Override
	public List<BiddinngInfo> getBiddingInfoList(String itemId, String userId) {
		// TODO Auto-generated method stub
		return biddingDao.getBiddingInfoList(itemId, userId);
	}

	@Override
	public void insertSuccess(String itemId, String userId, String successBid, int price) {
		// TODO Auto-generated method stub
		biddingDao.insertSuccess(itemId, userId, successBid, price);
	}

}
