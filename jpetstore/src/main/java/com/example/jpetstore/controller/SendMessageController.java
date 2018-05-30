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

	@Value("tiles/PostingFixedItem")
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
//		System.out.println("ø÷æ»µ«¡ˆ?");
//		return new PostingForm();
//	}
	
	@ModelAttribute("postingForm")
	public PostingForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		System.out.println("formBacking");
		return new PostingForm();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("postingForm") PostingForm postingForm,
			BindingResult result) throws Exception {
		
		if(result.hasErrors()) return formViewName;
		System.out.println("submit≈¨∏Ø");
		try {
			if(postingForm.isNewPosting()) {
				System.out.println("insert");
				postingForm.getItem().setItemId("»Ï»Ï");
				postingForm.getItem().setProductId("product");
				postingForm.getItem().setUsername("test");
				petStore.insertFixedItem(postingForm.getItem());
			}
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("ø¿∑˘");
			return formViewName;
			}
		
		 return successViewName;
		}
	

		
	}
		
	

