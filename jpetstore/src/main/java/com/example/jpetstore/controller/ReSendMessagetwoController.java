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
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Category;
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
@RequestMapping("/shop/reSendMessagetwo.do")
public class ReSendMessagetwoController { 

	@Value("tiles/ReSendMessagetwo") //PostingFixedItem
	private String formViewName;
	@Value("tiles/index")
	private String successViewName;

	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
//	@ModelAttribute("postingForm")
//	public PostingForm createPostingForm() {
//		System.out.println("왜안되지?");
//		return new PostingForm();
//	}
	
	@ModelAttribute("reSendMessagetwo")
	public SendMessage formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("formBacking 너되냐");
		return new SendMessage();

		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,

			@ModelAttribute("reSendMessagetwo") SendMessage reSendMessage,
			@ModelAttribute("writingMessageForm") SendMessage writingMessageForm,
			@RequestParam("senderId") String senderId,
			BindingResult result) throws Exception {
		
		if(result.hasErrors()) return formViewName;
		System.out.println("submit클릭");
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		try {
			//if(sendMessage.isNewMessage()) {

				System.out.println("re insert");

				reSendMessage.getMessage().setMessage(reSendMessage.getMessage().getMessage());
				reSendMessage.getMessage().setUserId(userSession.getAccount().getUsername());
				reSendMessage.getMessage().setReceiverId(senderId);
				reSendMessage.getMessage().setSenderId(userSession.getAccount().getUsername());
				petStore.sendMessage(reSendMessage.getMessage());
			//}
				// 아이디 맞는지 검증해주는 코드 있어야할듯
				
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("오류");
			return formViewName;
		}
		
		 return successViewName;
		}
	

		
	}
		
	