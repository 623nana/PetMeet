package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.CartDao;
import com.example.jpetstore.dao.mybatis.mapper.CartMapper;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Item;

@Repository
public class MybatisCartDao implements CartDao {
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public void insertCartItem(Item item, int qty) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.insertCartItem(item, qty);
	}

	@Override
	public void deleteCartItemByUsername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItemByUsername(username);
	}

	@Override
	public List<String> getCartItemByUsername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getCartItemByUsername(username);
	}

	@Override
	public void updateCartQty(@Param("item")Item item, @Param("qty")int qty) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.updateCartQty(item, qty);
	}

	@Override
	public int getQtyByItem(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getQtyByItem(item);
	}

	@Override
	public void deleteCartItemByItem(Item item) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItemByItem(item);
	}

	@Override
	public void updateCartOneQty(String itemId, String username) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.updateCartOneQty(itemId, username);
	}
	

}