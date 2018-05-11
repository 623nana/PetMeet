package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.SearchDao;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;


@Service("SearchServiceImpl")
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public List<Product> searchProductList(String keywords, String option) {
		// TODO Auto-generated method stub
		return searchDao.searchProductList(keywords, option);
	}

	@Override
	public List<Item> searchItemList(String keywords, String option) {
		// TODO Auto-generated method stub
		return searchDao.searchItemList(keywords, option);
	}

}
