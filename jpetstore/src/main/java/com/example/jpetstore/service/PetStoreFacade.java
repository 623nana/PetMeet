package com.example.jpetstore.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Comment;
//import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.domain.Ticket;
import com.example.jpetstore.domain.Message;

/**
 * JPetStore's central business interface.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
public interface PetStoreFacade {

	Account getAccount(String username);

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List<String> getUsernameList();


	List<Category> getCategoryList();

	Category getCategory(String categoryId);
	

	List<Product> getProductListByCategory(String categoryId);

	List<Product> searchProductList(String keywords);

	Product getProduct(String productId);
	
	void insertNewProduct(Item item);

	List<Item> getItemListByCategory(String categoryId);

	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

	boolean isItemInStock(String itemId);
	
	void insertFixedItem(Item item);
	
	String setProductId(String name);
	
	void updateFixedItem(Item item);
	
	void updateAuctionItem(Item item);

	void insertAuctionItem(Item item);
	
	void insertAuctionInfo(AuctionItem auctionItem);
	
	void insertBid(BiddingInfo biddingInfo);
	
	void insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);
	
	void insertComment(Comment comment) throws DataAccessException;
	
	void insertReComment(Comment comment) throws DataAccessException;
	
	List<Comment> getCommentByItemId(String itemId) throws DataAccessException;
	
	void sendMessage(Message msg) throws DataAccessException;
	
	List<Message> getMessageList(String userId)  throws DataAccessException;
	   
	List<Message> getMessageByUserId(String userId)  throws DataAccessException;
	   
	List<Message> getSendMessageByUserId(String userId)  throws DataAccessException;
	   
	Message readMessage(String messageId) throws DataAccessException;
	   
	void deleteMessage(String messageId) throws DataAccessException;
	   
	void reSendMessage(String receiverId) throws DataAccessException;
	
	AuctionItem getAuctionItem(String itemId) throws DataAccessException;

	void buyTicket(Ticket ticket);

	void useTicket(String userId);

	Ticket getTicketByUsername(String username);

	void insertBuyTicket(Ticket ticket);
	
	void deleteBuyTicketByUsername(Ticket ticket);
	
	int getMyTicketByUsername(String username);
	
	void insertInventory(Item item);
	
	void insertCartItem(@Param("item")Item item, @Param("username")String username, @Param("qty")int qty);
	
	void deleteCartItemByUsername(String username);
	
	List<String> getCartItemByUsername(String username);
	
	void updateCartQty(@Param("item")Item item, @Param("qty")int qty);
	
	Integer getQtyByItem(Item item);
	
	void deleteCartItemByItem(Item item);
	
	void updateCartOneQty(@Param("itemId")String itemId, @Param("username")String username);
	
	void insertDirectOrder(Order directOrder);

}