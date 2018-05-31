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
@RequestMapping("/shop/sendMessage.do")
public class SendMessageController { 

	@Value("tiles/message")
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
	
	@ModelAttribute("SendMessage")
	public WrtingMessageForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		System.out.println("formBacking");
		return new Message();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("writingMessageForm") WritingMessageForm writingMessageForm,
			BindingResult result) throws Exception {
		
		if(result.hasErrors()) return formViewName;
		System.out.println("submit클릭");
		try {
			if(writingMessageForm.isNewPosting()) {
				System.out.println("insert");
				writingMessageForm.getItem().setMessage("메세지");
				writingMessageForm.getItem().setUserId("user");
				writingMessageForm.getItem().setReceiverId("receiver");
				writingMessageForm.getItem().setSenderId("sender");
				petStore.insertFixedItem(writingMessageForm.getItem());
			}
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("오류");
			return formViewName;
			}
		
		 return successViewName;
		}
	

		
	}
		
	

