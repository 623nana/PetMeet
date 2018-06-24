package com.example.jpetstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class CommentController {

	
	private String successViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	
	@ModelAttribute("commentForm")
	public CommentForm updateComment(HttpServletRequest request,
			@RequestParam("commentId") String commentId,
			@RequestParam("commentNum") String commentNum,
			@RequestParam("itemId") String itemId) {
			
		CommentForm commentForm = new CommentForm(
				petStore.getComment(Integer.parseInt(commentId), Integer.parseInt(commentNum), itemId));
		return commentForm;
		
	}
	
	@RequestMapping(value="/shop/updateComment.do", method=RequestMethod.GET)
	public String showForm() {
		return "tiles/UpdateComment";
	}
	
	
	@RequestMapping(value="/shop/deleteComment.do")
	public String delete(HttpServletRequest request, 
			@RequestParam("commentId") String commentId,
			@RequestParam("commentNum") String commentNum,
			@RequestParam("itemId") String itemId,
			ModelMap model) {
		
		System.out.println(commentId);

		petStore.deleteComment(Integer.parseInt(commentId), Integer.parseInt(commentNum));
		
		Item item = this.petStore.getItem(itemId);
		List<Comment> comment = this.petStore.getCommentByItemId(itemId);
		CommentForm commentForm = new CommentForm();
		model.put("comment", comment);
		model.put("item", item);
		model.put("commentForm", commentForm);
		
		
		System.out.println("삭제됨");
		
		if(item.getClassify().equals("FIXED")) {
			successViewName = "tiles/ViewItem";
		} else {
			AuctionItem auctionItem = this.petStore.getAuctionItem(itemId);
			List<BiddingInfo> bidList = this.petStore.getBidListByItem(itemId);
			model.put("bidList", bidList);
			model.put("auctionItem", auctionItem);
			successViewName = "tiles/ViewAuctionItem";
		}
		
		
		return successViewName;
	}
	
	@RequestMapping(value="/shop/updateComment.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request, 
			@ModelAttribute("commentForm") CommentForm commentForm,
			ModelMap model) {
		
		petStore.updateComment(commentForm.getComment());
		System.out.println("업데이트");
		Item item = this.petStore.getItem(commentForm.getComment().getItemId());
		List<Comment> comment = this.petStore.getCommentByItemId(commentForm.getComment().getItemId());
		//CommentForm CommentForm = new CommentForm();
		model.put("comment", comment);
		model.put("item", item);
		model.put("commentForm", new CommentForm());
		
		
		if(item.getClassify().equals("FIXED")) {
			successViewName = "tiles/ViewItem";
		} else {
			AuctionItem auctionItem = this.petStore.getAuctionItem(commentForm.getComment().getItemId());
			List<BiddingInfo> bidList = this.petStore.getBidListByItem(commentForm.getComment().getItemId());
			model.put("bidList", bidList);
			model.put("auctionItem", auctionItem);
			successViewName = "tiles/ViewAuctionItem";
		}
		
		
		return successViewName;
	}
	
	
	
}
