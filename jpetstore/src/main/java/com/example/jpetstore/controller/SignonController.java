package com.example.jpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.CartItem;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.PetStoreFacade;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class SignonController { 

	private PetStoreFacade petStore;
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("dbCart")
	public Cart createCartByDB() {
		return new Cart();
	}

	@RequestMapping("/shop/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,HttpSession session, SessionStatus status,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,		
			@ModelAttribute("dbCart") Cart dbcart,
			Model model) throws Exception {
		Account account = petStore.getAccount(username, password);
		if (account == null) {
			return new ModelAndView("Error", "message", 
					"Invalid username or password.  Sqignon failed.");
		}
		else {			
			Cart cart = (Cart)session.getAttribute("sessionCart");
			if(cart != null && cart.getNumberOfItems() != 0) {				
				PagedListHolder<CartItem> c = cart.getCartItemList();
				List<CartItem> cartitem = c.getPageList();				
				for(CartItem item: cartitem) {
					petStore.insertCartItem(item.getItem(), item.getQuantity());
				}
				dbcart = cart;
				session.removeAttribute("sessionCart");
			}
			
			UserSession userSession = new UserSession(account);
			PagedListHolder<Product> myList = new PagedListHolder<Product>(this.petStore.getProductListByCategory(account.getFavouriteCategoryId()));
			myList.setPageSize(4);
			userSession.setMyList(myList);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else {
				return new ModelAndView("tiles/index"); // tiles를 이용한 레이아웃
			}
		}
	}
}
