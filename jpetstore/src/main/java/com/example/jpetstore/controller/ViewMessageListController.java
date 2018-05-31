package com.example.jpetstore.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@RequestMapping("/shop/messageList.do")
public class ViewMessageListController { 

//	private PetStoreFacade petStore;
//
//	@Autowired
//	public void setPetStore(PetStoreFacade petStore) {
//		this.petStore = petStore;
//	}

//	@RequestMapping("/shop/viewItem.do")
//	public String handleRequest(
//			@RequestParam("itemId") String itemId,
//			ModelMap model) throws Exception {
//		Item item = this.petStore.getItem(itemId);
//		model.put("item", item);
//		model.put("product", item.getProduct());
//		return "Item";
//	}
//	
//	@RequestMapping("/shop/viewOrder.do")
//	public ModelAndView handleRequest(
//			@ModelAttribute("userSession") UserSession userSession,
//			@RequestParam("orderId") int orderId
//			) throws Exception {
//		Order order = this.petStore.getOrder(orderId);
//		if (userSession.getAccount().getUsername().equals(order.getUsername())) {
//			return new ModelAndView("ViewOrder", "order", order);
//		}
//		else {
//			return new ModelAndView("Error", "message", "You may only view your own orders.");
//		}
//	}
		
}
		
	

