package com.example.jpetstore.controller;

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
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class RegisterCommentController {

	//@Value("tiles/ViewItem")
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
	@RequestMapping(value="/shop/registerComment.do", method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	
	@RequestMapping(value= "/shop/registerComment.do", method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("reCommentForm") ReCommentForm reCommentForm,
			@ModelAttribute("commentForm") CommentForm commentForm,
			@RequestParam("commentId") String commentId,
			@RequestParam("itemId") String itemId,
			BindingResult result, ModelMap model) throws Exception {
		//if (result.hasErrors()) return formViewName;
		System.out.println("¸®´ñ±Û");
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		
		try {
			if( commentForm.getComment().getNewComment().equals("first") ) {
				System.out.println("¸®´ñ´Þ°í ¿ø·¡´ñ±Ûinsert");
				
				commentForm.getComment().setCommenterName(account.getUsername());
				
				petStore.insertComment(commentForm.getComment());
				
				Item item = this.petStore.getItem(commentForm.getComment().getItemId());
				
				if(item.getClassify().equals("FIXED")) {
					model.put("item", item);
					successViewName = "tiles/ViewItem";
				} else if(item.getClassify().equals("AUCTION")) {
					AuctionItem auctionItem = this.petStore.getAuctionItem(itemId);
					model.put("auctionItem", auctionItem);
					successViewName = "tiles/ViewAuctionItem";
				}
				
				List<Comment> comment = this.petStore.getCommentByItemId(itemId);
				model.put("comment", comment);
				model.addAttribute("commentId", commentForm.getComment().getCommentId());
			
			}	else {
				
				int commId = Integer.parseInt(commentId);
			
				System.out.println("ÁøÂ¥¸®´ñ±Û");
				reCommentForm.getComment().setCommenterName(account.getUsername());
				reCommentForm.getComment().setCommentId(commId);
				reCommentForm.getComment().setItemId(itemId);
				
				petStore.insertReComment(reCommentForm.getComment());
				
				Item item = this.petStore.getItem(itemId);
				
				if(item.getClassify().equals("FIXED")) {
					model.put("item", item);	
					successViewName = "tiles/ViewItem";
					System.out.println("Àß³ª¿È");
					
				} else if(item.getClassify().equals("AUCTION")) {
					
					System.out.println("¿Á¼Ç ¸®´ñ±Û");
					AuctionItem auctionItem = this.petStore.getAuctionItem(itemId);
					model.put("auctionItem", auctionItem);
					successViewName = "tiles/ViewAuctionItem";
				}
				
				List<Comment> comment = this.petStore.getCommentByItemId(itemId);
				model.put("comment", comment);
				model.addAttribute("commentId", commentForm.getComment().getCommentId());

			}		
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("¿À·ù");
			return successViewName;
		}
		return successViewName;
	}
	
	@RequestMapping(value= {"/shop/viewItem.do", "/shop/viewAuctionItem.do"}, method = RequestMethod.POST)
	public String onSubmit2(HttpServletRequest request, HttpSession session,
			@ModelAttribute("reCommentForm") ReCommentForm reCommentForm,
			@ModelAttribute("commentForm") CommentForm commentForm,
			@Param("commentId") String commentId,
			@Param("itemId") String itemId,
			BindingResult result, ModelMap model) throws Exception {
		//if (result.hasErrors()) return formViewName;
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		
		try {
			if( commentForm.isNewComment() ) {
				System.out.println("Á¤Âû ¿ø·¡ ´ñ±Û insert");
				
				commentForm.getComment().setCommenterName(account.getUsername());
				
				petStore.insertComment(commentForm.getComment());
				
				Item item = this.petStore.getItem(commentForm.getComment().getItemId());
				String status = item.getClassify();
				
				if(status.equals("FIXED")) {
					model.put("item", item);
					model.addAttribute("commentId", commentForm.getComment().getCommentId());
					successViewName = "tiles/ViewItem";

				} else if(item.getClassify().equals("AUCTION")) {
					System.out.println("¿Á¼Ç ¿ø´ñ±Û");
					AuctionItem auctionItem = this.petStore.getAuctionItem(itemId);
					model.put("auctionItem", auctionItem);
					model.addAttribute("commentId", commentForm.getComment().getCommentId());
					successViewName = "tiles/ViewAuctionItem";
				}
				
				List<Comment> comment = this.petStore.getCommentByItemId(itemId);
				model.put("comment", comment);
				model.addAttribute("commentId", commentForm.getComment().getCommentId());
			
			}	
				
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("¿À·ù");
			return successViewName;
		}
		return successViewName;
	}
}
