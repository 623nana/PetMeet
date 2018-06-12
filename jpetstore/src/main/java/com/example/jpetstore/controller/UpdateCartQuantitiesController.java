package com.example.jpetstore.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.CartItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class UpdateCartQuantitiesController { 
	
	@Autowired
	private PetStoreFacade petStore;

	@ModelAttribute("dbCart")
	public Cart createCartByDB(HttpSession session) {
		Cart cart = new Cart();		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if(userSession != null) {
			String username = userSession.getAccount().getUsername();
			List<String> itemId = petStore.getCartItemByUsername(username);
			for(String id: itemId) {
				Item item = petStore.getItem(id);
				int qty = petStore.getQtyByItem(item);
				boolean isInStock = this.petStore.isItemInStock(id);
				cart.addItem(item, isInStock);
				cart.setQuantityByItemId(item.getItemId(), qty);
			}
		}
		return cart;
	}	
	
	@RequestMapping("/shop/updateCartQuantities.do")
	public ModelAndView handleRequest(
			HttpServletRequest request,	
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("dbCart") Cart dbcart) throws Exception {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		if(userSession != null) {
			Iterator<CartItem> cartItems = dbcart.getAllCartItems();
			while (cartItems.hasNext()) {
				CartItem cartItem = (CartItem) cartItems.next();
				String itemId = cartItem.getItem().getItemId();
				System.out.println(itemId);
				try {
					int quantity = Integer.parseInt(request.getParameter(itemId));
					System.out.println(quantity);
					Item item = petStore.getItem(itemId);
					dbcart.setQuantityByItemId(itemId, quantity);
					petStore.updateCartQty(item, quantity);
					if (quantity < 1) {
						cartItems.remove();						
						petStore.deleteCartItemByItem(item);
					}
				}
				catch (NumberFormatException ex) {
					// ignore on purpose
				}
			}
			return new ModelAndView("tiles/Cart", "cart", dbcart);
		} 
		else {
			Iterator<CartItem> cartItems = cart.getAllCartItems();
			while (cartItems.hasNext()) {
				CartItem cartItem = (CartItem) cartItems.next();
				String itemId = cartItem.getItem().getItemId();
				try {
					int quantity = Integer.parseInt(request.getParameter(itemId));
					cart.setQuantityByItemId(itemId, quantity);
					if (quantity < 1) {
						cartItems.remove();
					}
				}
				catch (NumberFormatException ex) {
					// ignore on purpose
				}
			}
			return new ModelAndView("tiles/Cart", "cart", cart);
		}		
	}

}
