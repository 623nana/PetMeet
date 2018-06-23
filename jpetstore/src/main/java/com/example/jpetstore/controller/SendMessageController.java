package com.example.jpetstore.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.MessageValidator;
import com.example.jpetstore.service.OrderValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/sendMessage.do")
public class SendMessageController { 

	@Value("tiles/SendMessage") //PostingFixedItem
	private String formViewName;
	@Value("tiles/index")
	private String successViewName;

	@Autowired
	private MessageValidator messageValidator;
	public void setValidator(MessageValidator validator) {
		this.messageValidator = validator;
	}
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	
	
//	@ModelAttribute("postingForm")
//	public PostingForm createPostingForm() {
//		System.out.println("�솢�븞�릺吏�?");
//		return new PostingForm();
//	}
	
	@ModelAttribute("sendMessage")
	public SendMessage formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("formBacking2");
		return new SendMessage();		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("sendMessage") SendMessage sendMessage,
			BindingResult result) throws Exception {

		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		try {

				System.out.println("insert");

				sendMessage.getMessage().setMessage(sendMessage.getMessage().getMessage());
				sendMessage.getMessage().setUserId(userSession.getAccount().getUsername());
				sendMessage.getMessage().setReceiverId(sendMessage.getMessage().getReceiverId());
				sendMessage.getMessage().setSenderId(userSession.getAccount().getUsername());
				
				messageValidator.validate(sendMessage, result);
//				new MessageValidator().validate(sendMessage, result);
				if(result.hasErrors()) return formViewName;
				
				petStore.sendMessage(sendMessage.getMessage());
				

				 return successViewName;
		}
		catch (DataIntegrityViolationException ex) {
//			System.out.println("�삤瑜�");
			return formViewName;
		}
		
		 //return successViewName;
	}
//	@InitBinder("SendMessage")
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new MessageValidator());
//	}

//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new MessageValidator());
//	}

	

		
}
		
	
