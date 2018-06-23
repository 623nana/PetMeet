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
	public void insertCartItem(@Param("item")Item item, @Param("qty")int qty, @Param("username")String username) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.insertCartItem(item, qty, username);
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
	public void updateCartQty(@Param("item")Item item, @Param("qty")int qty, @Param("username")String username) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.updateCartQty(item, qty, username);
	}

	@Override
	public int getQtyByItem(@Param("item")Item item, @Param("username")String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getQtyByItem(item, username);
	}

	@Override
	public void deleteCartItemByItem(@Param("item")Item item, @Param("username")String username) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItemByItem(item, username);
	}

	@Override
	public void updateCartOneQty(String itemId, String username) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.updateCartOneQty(itemId, username);
	}

	@Override
	public String getCartItem(String itemId, String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getCartItem(itemId, username);
	}
	
	@Override
	public void deleteCartItemByItemId(@Param("itemId")String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItemByItemId(itemId);
	}

}