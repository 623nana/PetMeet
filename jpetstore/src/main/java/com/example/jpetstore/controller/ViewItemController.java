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
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
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
	
	@Value("tiles/ViewAuctionItem")
	private String successViewAuction;

	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping("/shop/viewItem.do")
	public String handleRequest(
			@RequestParam("itemId") String itemId,
			ModelMap model) throws Exception {
		System.out.println("�����ۺ���");
		
		Item item = this.petStore.getItem(itemId);
			List<Comment> comment = this.petStore.getCommentByItemId(itemId);
			CommentForm commentForm = new CommentForm();
			model.put("item", item);
			model.put("comment", comment);
			model.put("commentForm", commentForm);
			return successViewName;
			
		
		
	}
	
	@RequestMapping("/shop/deletePosting.do")
	public ModelAndView handleRequest3(
			@RequestParam("itemId") String itemId,
			ModelMap model) throws Exception {
		System.out.println("����Ʈ");
		
		this.petStore.deleteMyItem(itemId);
		return new ModelAndView("index", "index", null);
		
	}
	
	@RequestMapping("/shop/viewAuctionItem.do")
	public String handleRequest2(
			@RequestParam("itemId") String itemId,
			ModelMap model) throws Exception {
		System.out.println("�����ۺ���");
		
			System.out.println("���Ǿ�����!");
			AuctionItem auctionItem = this.petStore.getAuctionItem(itemId);
			List<BiddingInfo> bidList = this.petStore.getBidListByItem(itemId);
			List<Comment> comment = this.petStore.getCommentByItemId(itemId);
			CommentForm commentForm = new CommentForm();
			BiddingInfo bidInfo = new BiddingInfo();
			System.out.println(itemId);
			//BiddingInfo biddingInfo = petStore.getSuccessBidder(itemId);
			
			//System.out.println(biddingInfo.getExpectPrice());
			model.put("auctionItem", auctionItem);
			model.put("comment", comment);
			model.put("commentForm", commentForm);
			model.put("bidInfo", bidInfo);
			model.put("bidList", bidList);
			//model.put("biddingInfo", biddingInfo);
			return successViewAuction;
		}
		
		
		
	

}