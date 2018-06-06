package com.example.jpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
public class ViewItemController { 

	@Value("tiles/ViewItem")
	private String successViewName;

	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
//	
//	@ModelAttribute("insertComment")
//	public InsertComment formBackingObject(HttpServletRequest request)
//			throws Exception {
//		System.out.println("들어옴");
//		return new InsertComment();
//	}
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public String showForm() {
//		return successViewName;
//	}
	@RequestMapping(value="/shop/viewItem.do", method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("commentForm") CommentForm commentForm,
			@ModelAttribute("reCommentForm") ReCommentForm reCommentForm,
			BindingResult result, ModelMap model) throws Exception {
		//if (result.hasErrors()) return formViewName;
		System.out.println("viewItem submit 클릭");
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		
		try {
			if( commentForm.getComment().getNewComment().equals("first") ) {
				System.out.println("원래댓글insert");
				
				commentForm.getComment().setCommenterName(account.getUsername());
				
				petStore.insertComment(commentForm.getComment());
				
				Item item = this.petStore.getItem(commentForm.getComment().getItemId());
				List<Comment> comment = this.petStore.getCommentByItemId(commentForm.getComment().getItemId());
				
				model.put("item", item);
				model.put("comment", comment);
				model.addAttribute("commentId", commentForm.getComment().getCommentId());
			
			}	
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("오류");
			return successViewName;
		}
		return successViewName;
	}
	
	@RequestMapping(value="/shop/viewItem.do", method = RequestMethod.GET)
	public String handleRequest(
			@RequestParam("itemId") String itemId,
			ModelMap model) throws Exception {
		System.out.println("아이템보기");
		Item item = this.petStore.getItem(itemId);
		List<Comment> comment = this.petStore.getCommentByItemId(itemId);
		CommentForm commentForm = new CommentForm();
		//ReCommentForm reCommentForm = new ReCommentForm();
		model.put("item", item);
		model.put("comment", comment);
		model.put("commentForm", commentForm);
		//model.put("reCommentForm", reCommentForm);
		//model.put("product", item.getProduct());
		return successViewName;
	}

}
