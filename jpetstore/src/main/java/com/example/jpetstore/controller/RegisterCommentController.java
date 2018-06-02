package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/registerComment.do")
public class RegisterCommentController {
	
	@Value("tiles/RegisterComment")
	private String formViewName;
	@Value("tiles/index")
	private String successViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("registerComment")
	public RegisterComment formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("formBacking2");
		return new RegisterComment();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("registerComment") RegisterComment registerComment,
			@ModelAttribute("writingCommentForm") RegisterComment writingMessageForm,
			BindingResult result) throws Exception {
		if (result.hasErrors()) return formViewName;
		System.out.println("submit 클릭");
		
		UserSession userSession = (UserSession)request.getAttribute("userSession");
		
		try {
			//if(registerComment.isNewComment()) {
			
				System.out.println("insert");

				registerComment.getComment().setComment(registerComment.getComment().getComment());
				registerComment.getComment().setCommenterName(userSession.getAccount().getUsername());
				registerComment.getComment().setCommentId(registerComment.getComment().getCommentId());
				registerComment.getComment().setCommentNum(registerComment.getComment().getCommentNum());
				petStore.registerComment(registerComment.getComment());
			//}
					
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("오류");
			return formViewName;
		}
		
		 return successViewName;
	}

}
