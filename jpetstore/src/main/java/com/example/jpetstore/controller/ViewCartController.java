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
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class ViewCartController { 
	
	@Autowired
	private PetStoreFacade petStore;
	
	@ModelAttribute("sessionCart")
	public Cart createCart(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("sessionCart");
		if (cart == null) cart = new Cart();
		return cart;
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
				System.out.println("1" + item.getItemId());				
				int qty = petStore.getQtyByItem(item, username);
				System.out.println(qty);			
				boolean isInStock = this.petStore.isItemInStock(id);
				cart.addItem(item, isInStock);
				cart.setQuantityByItemId(item.getItemId(), qty);
			}
		}
		return cart;
	}	
	
	@RequestMapping("/shop/viewCart.do")
	public ModelAndView viewCart(
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("dbCart") Cart dbcart) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if(userSession != null) {
			handleRequest(page, dbcart, userSession);
			return new ModelAndView("tiles/Cart", "cart", dbcart);
		}
		else {
			handleRequest(page, cart, userSession);
			return new ModelAndView("tiles/Cart", "cart", cart);
		}		
	}

	@RequestMapping("/shop/checkout.do")
	public ModelAndView checkout(
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("dbCart") Cart dbcart) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if(userSession != null) {
			handleRequest(page, dbcart, userSession);
			return new ModelAndView("tiles/Checkout", "cart", dbcart);
		}
		else {
			handleRequest(page, cart, userSession);
			return new ModelAndView("tiles/Checkout", "cart", cart);
		}
	}
	
	private void handleRequest(String page, Cart cart, UserSession userSession)
			throws Exception {
		if (userSession != null) {
			if ("next".equals(page)) {
				userSession.getMyList().nextPage();
			}
			else if ("previous".equals(page)) {
				userSession.getMyList().previousPage();
			}
		}
		if ("nextCart".equals(page)) {
			cart.getCartItemList().nextPage();
		}
		else if ("previousCart".equals(page)) {
			cart.getCartItemList().previousPage();
		}
	}
}