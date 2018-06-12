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
public class RemoveItemFromCartController { 
	
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

	@RequestMapping("/shop/removeItemFromCart.do")
	public ModelAndView handleRequest(
			@RequestParam("workingItemId") String workingItemId,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("dbCart") Cart dbcart,
			HttpServletRequest request
		) throws Exception {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if(userSession != null) {
			System.out.println("技记乐");
			System.out.println(workingItemId);
			dbcart.removeItemById(workingItemId);
			Item item = petStore.getItem(workingItemId);
			petStore.deleteCartItemByItem(item);
			return new ModelAndView("tiles/Cart", "cart", dbcart);
		}
		else {
			System.out.println("技记绝");
			cart.removeItemById(workingItemId);
			return new ModelAndView("tiles/Cart", "cart", cart);
		}
	}
}
