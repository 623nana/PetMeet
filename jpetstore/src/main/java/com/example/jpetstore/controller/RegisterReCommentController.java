package com.example.jpetstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@RequestMapping("/shop/registerComment.do")
public class RegisterReCommentController {

	@Value("tiles/ViewItem")
	private String successViewName;
	
	@Value("tiles/RegisterReComment")
	private String formViewName;
	
	
	@Autowired
	private PetStoreFacade petStore;
	
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("reCommentForm")
	public ReCommentForm formBackingObject(HttpServletRequest request) 
			throws Exception {

		return new ReCommentForm();
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("reCommentForm") ReCommentForm reCommentForm,
			@ModelAttribute("commentForm") CommentForm commentForm,
			@RequestParam("commentId") String commentId,
			@RequestParam("itemId") String itemId,
			BindingResult result, ModelMap model) throws Exception {
		//if (result.hasErrors()) return formViewName;
		System.out.println("submit Å¬¸¯");
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		
		try {
			if( commentForm.getComment().getNewComment().equals("first") ) {
				System.out.println("¿ø·¡´ñ±Ûinsert");
				
				commentForm.getComment().setCommenterName(account.getUsername());
				
				petStore.insertComment(commentForm.getComment());
				
				Item item = this.petStore.getItem(commentForm.getComment().getItemId());
				List<Comment> comment = this.petStore.getCommentByItemId(commentForm.getComment().getItemId());
				
				model.put("item", item);
				model.put("comment", comment);
				model.addAttribute("commentId", commentForm.getComment().getCommentId());
			
			}	else {
				int commId = Integer.parseInt(commentId);
			
				System.out.println("¸®´ñ±Û²ó¿ì");
				reCommentForm.getComment().setCommenterName(account.getUsername());
			
				reCommentForm.getComment().setCommentId(commId);
				reCommentForm.getComment().setItemId(itemId);
				petStore.insertReComment(reCommentForm.getComment());
				
				Item item = this.petStore.getItem(itemId);
				List<Comment> comment = this.petStore.getCommentByItemId(reCommentForm.getComment().getItemId());
				
				model.put("item", item);
				model.put("comment", comment);
				model.addAttribute("commentForm", new CommentForm());

			}
			
				
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("¿À·ù");
			return successViewName;
		}
		return successViewName;
	}
}
