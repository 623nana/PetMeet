package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Item;


public interface CartMapper {

   void insertCartItem(@Param("item")Item item, @Param("qty")int qty, @Param("username")String username);
   
   void deleteCartItemByUsername(String username);
   
   List<String> getCartItemByUsername(String username);
   
   void updateCartQty(@Param("item")Item item, @Param("qty")int qty, @Param("username")String username);
   
   int getQtyByItem(@Param("item")Item item, @Param("username")String username);
   
   void deleteCartItemByItem(@Param("item")Item item, @Param("username")String username);
   
   void updateCartOneQty(@Param("itemId")String itemId, @Param("username")String username);
   
   String getCartItem(@Param("itemId")String itemId, @Param("username")String username);
   
   void deleteCartItemByItemId(@Param("itemId") String itemId);
}
