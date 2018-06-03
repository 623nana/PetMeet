package com.example.jpetstore.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Message;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
//@RequestMapping("/shop/readMessage.do")
public class ReadMessageController { 

	private PetStoreFacade petStore;
	String msgId ="";

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	
	@RequestMapping("/shop/readMessage.do")
	public ModelAndView handleRequest(
		@ModelAttribute("userSession") UserSession userSession,
		@RequestParam("messageId") String messageId
		) throws Exception {
		msgId = "";
		msgId += messageId; 
		return new ModelAndView("ReadMessage", "readMessage", 
				petStore.readMessage(messageId));
	}
	
	@RequestMapping("/shop/readMessagetwo.do")
	public ModelAndView handleRequest2(
		@ModelAttribute("userSession") UserSession userSession,
		@RequestParam("messageId") String messageId
		) throws Exception {
		msgId = "";
		msgId += messageId; 
		return new ModelAndView("ReadMessagetwo", "readMessagetwo", 
				petStore.readMessage(messageId));
	}
	

	@RequestMapping("/shop/deleteMessage.do")
	public ModelAndView handleRequest(
		) throws Exception {
		System.out.println("¿À´× + "+msgId);
		petStore.deleteMessage(msgId);
		return new ModelAndView("index", "index", 
				null);
	}
	

}