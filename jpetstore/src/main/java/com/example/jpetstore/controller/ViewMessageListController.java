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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Message;
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
//@SessionAttribute("message"})
@RequestMapping("/shop/messageList.do")
@SessionAttributes("userSession")
public class ViewMessageListController { 
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	//@RequestParam("userId") String userId,
//	@RequestMapping("/shop/messageList.do")
//	public String handleRequest(
//			ModelMap model
//			) throws Exception {
//		System.out.println("¿Ö¾È´ó");
////		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//		
//		List<Message> message = this.petStore.getMessageList("123456"); //
//		PagedListHolder<Message> messageList = new PagedListHolder<Message>(this.petStore.getMessageByUserId("123456"));
//		messageList.setPageSize(4);
//		model.put("message", message);
//		model.put("messageList", messageList);
//		return "Message";
//	}
//
//	@RequestMapping("/shop/viewCategory2.do")
//	public String handleRequest2(
//			@RequestParam("page") String page,
//			@ModelAttribute("category") Category category,
//			@ModelAttribute("productList") PagedListHolder<Product> productList,
//			BindingResult result) throws Exception {
//		if (category == null || productList == null) {
//			throw new IllegalStateException("Cannot find pre-loaded category and product list");
//		}
//		if ("next".equals(page)) { productList.nextPage(); }
//		else if ("previous".equals(page)) { productList.previousPage(); }
//		return "Category";
//	}

		
}
		
	

