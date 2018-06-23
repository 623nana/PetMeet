package com.example.jpetstore.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.dao.CartDao;
import com.example.jpetstore.dao.CategoryDao;
import com.example.jpetstore.dao.CommunicateDao;
import com.example.jpetstore.dao.ItemDao;
import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.ProductDao;
import com.example.jpetstore.dao.TicketDao;
import com.example.jpetstore.dao.mybatis.MyException;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Message;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.domain.Ticket;

/**
 * JPetStore primary business object.
 * 
 * <p>This object makes use of five DAO objects, decoupling it
 * from the details of working with persistence APIs. So
 * although this application uses iBATIS for data access,
 * a different persistence tool could be dropped in without
 * breaking this class.
 *
 * <p>The DAOs are made available to the instance of this object
 * using Dependency Injection. (The DAOs are in turn configured using
 * Dependency Injection themselves.) We use Setter Injection here,
 * exposing JavaBean setter methods for each DAO. This means there is
 * a JavaBean property for each DAO. In the present case, the properties
 * are write-only: there are no corresponding getter methods. Getter
 * methods for configuration properties are optional: Implement them
 * only if you want to expose those properties to other business objects.
 *
 * <p>There is one instance of this class in the JPetStore application.
 * In Spring terminology, it is a "singleton", referring to a
 * per-Application Context singleton. The factory creates a single
 * instance; there is no need for a private constructor, static
 * factory method etc as in the traditional implementation of
 * the Singleton Design Pattern. 
 *
 * <p>This is a POJO. It does not depend on any Spring APIs.
 * It's usable outside a Spring container, and can be instantiated
 * using new in a JUnit test. However, we can still apply declarative
 * transaction management to it using Spring AOP.
 *
 * <p>This class defines a default transaction annotation for all methods.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified by Changsup Park
 */
@Service
@Transactional
public class PetStoreImpl implements PetStoreFacade { 
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CommunicateDao communicateDao;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private CartDao cartDao;

	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------

	public Account getAccount(String username) {
		return accountDao.getAccount(username);
	}

	public Account getAccount(String username, String password) {
		return accountDao.getAccount(username, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public List<String> getUsernameList() {
		return accountDao.getUsernameList();
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}

	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}
	
	public void insertNewProduct(Item item) {
		itemDao.insertNewProduct(item);
	}

	public List<Item> getItemListByCategory(String categoryId){
		return itemDao.getItemListByCategory(categoryId);
	}
	
	public List<Item> getItemListByProduct(String productId) {
		return itemDao.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) {
		return itemDao.getItem(itemId);
	}

	public AuctionItem getAuctionItem(String itemId) {
		return itemDao.getAuctionItem(itemId);
	}
	
	public boolean isItemInStock(String itemId) {
		return itemDao.isItemInStock(itemId);
	}

	public void insertFixedItem(Item item) {
		itemDao.insertFixedItem(item);
	}
	
	public void updateFixedItem(Item item) {
		itemDao.updateFixedItem(item);
	}
	
	public void updateAuctionItem(Item item) {
		itemDao.updateAuctionItem(item);
	}
	
	public void insertAuctionItem(Item item) {
		itemDao.insertAuctionItem(item);
	}
	
	public void insertBid(BiddingInfo biddingInfo) {
		itemDao.insertBid(biddingInfo);
	}
	public void insertAuctionInfo(AuctionItem auctionItem) {
		itemDao.insertAuctionInfo(auctionItem);
	}
	
	public String setProductId(String name) {
		return itemDao.setProductId(name);
	}
	
	public void insertOrder(Order order) {
		try {
			orderDao.insertOrder(order);
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		itemDao.updateQuantity(order);  
	}
	
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public List<Order> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}
	
	public void sendMessage(Message msg) {
		communicateDao.sendMessage(msg);
		return;
	}

	@Override
	public List<Message> getMessageList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateDao.getMessageList(userId);
	}

	@Override
	public List<Message> getMessageByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateDao.getMessageByUserId(userId);
	}

	@Override
	public List<Message> getSendMessageByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateDao.getSendMessageByUserId(userId);
	}

	@Override
	public Message readMessage(String messageId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateDao.readMessage(messageId);
	}

	@Override
	public void deleteMessage(String messageId) throws DataAccessException {
		// TODO Auto-generated method stub
		communicateDao.deleteMessage(messageId);
	}

	@Override
	public void reSendMessage(String receiverId) throws DataAccessException {
		// TODO Auto-generated method stub
		communicateDao.reSendMessage(receiverId);
		
	}

	public void insertComment(Comment comment) {
		communicateDao.insertComment(comment);
	}
	
	public void insertReComment(Comment comment) {
		communicateDao.insertReComment(comment);
	}
	
	public List<Comment> getCommentByItemId(String itemId) {
		return communicateDao.getCommentByItemId(itemId);
	}
	
	public void buyTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketDao.buyTicket(ticket);
	}

	public void useTicket(String userId) {
		// TODO Auto-generated method stub
		ticketDao.useTicket(userId);
	}

	public Ticket getTicketByUsername(String username) {
		// TODO Auto-generated method stub
		return ticketDao.getTicketByUsername(username);
	}

	public void insertBuyTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketDao.insertBuyTicket(ticket);
	}
	
	public void deleteBuyTicketByUsername(Ticket ticket) {
		ticketDao.deleteBuyTicketByUsername(ticket);
	}

	@Override
	public int getMyTicketByUsername(String username) {
		// TODO Auto-generated method stub
		return ticketDao.getMyTicketByUsername(username);
	}

	@Override
	public void insertInventory(Item item) {
		// TODO Auto-generated method stub
		itemDao.insertInventory(item);
	}

	@Override
	public void insertCartItem(@Param("item")Item item, @Param("qty")int qty, @Param("username")String username) {
		// TODO Auto-generated method stub
		cartDao.insertCartItem(item, qty, username);
	}
	@Override
	public void deleteCartItemByUsername(String username) {
		// TODO Auto-generated method stub
		cartDao.deleteCartItemByUsername(username);
	}

	@Override
	public List<String> getCartItemByUsername(String username) {
		// TODO Auto-generated method stub
		return cartDao.getCartItemByUsername(username);
	}

	@Override
	public void updateCartQty(@Param("item")Item item, @Param("qty")int qty, @Param("username")String username) {
		// TODO Auto-generated method stub
		cartDao.updateCartQty(item, qty, username);
	}

	@Override
	public int getQtyByItem(@Param("item")Item item, @Param("username")String username) {
		// TODO Auto-generated method stub
		return cartDao.getQtyByItem(item, username);
	}

	@Override
	public void deleteCartItemByItem(@Param("item")Item item, @Param("username")String username) {
		// TODO Auto-generated method stub
		cartDao.deleteCartItemByItem(item, username);
	}
	@Override
	public void updateCartOneQty(@Param("itemId")String itemId, @Param("username")String username) {
		// TODO Auto-generated method stub
		cartDao.updateCartOneQty(itemId, username);
	}

	@Override
	public String getCartItem(String itemId, String username) {
		// TODO Auto-generated method stub
		return cartDao.getCartItem(itemId, username);
	}
	
	@Override
	public void insertDirectOrder(Order directOrder) {
		// TODO Auto-generated method stub
		itemDao.updateQuantity(directOrder);	    
		orderDao.insertDirectOrder(directOrder);
	}
	
	//상품 검색(species, userId)
	public List<Item> getItemListBySpecies(String species) {
		return itemDao.getItemListBySpecies(species);
	}
	
	public List<Item> getItemListByUserId(String userId) {
		return itemDao.getItemListByUserId(userId);
	}

	@Override
	public boolean isAccount(String username) {
		// TODO Auto-generated method stub
		if (accountDao.isAccount(username))
			return true;
		else
			return false;
	}

	@Override
	public void deleteMyItem(String itemId) {
		// TODO Auto-generated method stub
		itemDao.deleteMyItem(itemId);
		cartDao.deleteCartItemByItemId(itemId);
	}


}