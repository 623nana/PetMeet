package com.example.jpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class AddItemToCartController { 

	@Autowired
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@ModelAttribute("sessionCart")
	public Cart createCart() {
		return new Cart();
	}
	
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
	
	@RequestMapping("/shop/addItemToCart.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("workingItemId") String workingItemId,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("dbCart") Cart dbcart
			) throws Exception {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if(userSession != null) {
			if (dbcart.containsItemId(workingItemId)) {
				dbcart.incrementQuantityByItemId(workingItemId);
				petStore.updateCartOneQty(workingItemId, userSession.getAccount().getUsername());
			}
			else {
				boolean isInStock = this.petStore.isItemInStock(workingItemId);
				Item item = this.petStore.getItem(workingItemId);
				petStore.insertCartItem(item, userSession.getAccount().getUsername(), 1);
				dbcart.addItem(item, isInStock);
			}			
			return new ModelAndView("tiles/Cart", "cart", dbcart);
		}
		else {		
			if (cart.containsItemId(workingItemId)) {
				cart.incrementQuantityByItemId(workingItemId);
			}
			else {
				// isInStock is a "real-time" property that must be updated
				// every time an item is added to the cart, even if other
				// item details are cached.
				boolean isInStock = this.petStore.isItemInStock(workingItemId);
				Item item = this.petStore.getItem(workingItemId);				
				cart.addItem(item, isInStock);
			}
			return new ModelAndView("tiles/Cart", "cart", cart);
		}
	}
}