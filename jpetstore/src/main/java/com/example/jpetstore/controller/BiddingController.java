package com.example.jpetstore.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/auction")
public class BiddingController {
	
	@Value("shop/index")
	private String successViewName;

	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/post")
	public String createBid(@ModelAttribute BiddingInfo bidInfo, HttpServletResponse response
				,ModelMap model) {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ();
		String biddingTime = formatter.format ( currentTime );
		
		
		bidInfo.setBiddingTime(biddingTime);
		
		petStore.insertBid(bidInfo);
		petStore.updateCurrentMaxPrice(bidInfo);
		
		
		AuctionItem auctionItem = this.petStore.getAuctionItem(bidInfo.getItemId());
		
		if(bidInfo.getExpectPrice() == auctionItem.getLimitPrice()) {
			Date curTime = new Date();
			SimpleDateFormat update = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			String auctionTime = update.format(curTime);
			String itemId = bidInfo.getItemId();
			
			System.out.println(itemId);
			
			petStore.updateCloseTime(auctionTime, itemId);
			
			petStore.testScheduler(currentTime, itemId);
			System.out.println("완료!");
			
			
		}
		
		List<BiddingInfo> bidList = this.petStore.getBidListByItem(bidInfo.getItemId());
		List<Comment> comment = this.petStore.getCommentByItemId(bidInfo.getItemId());
		CommentForm commentForm = new CommentForm();

		model.put("auctionItem", auctionItem);
		model.put("comment", comment);
		model.put("commentForm", commentForm);
		model.put("bidInfo", new BiddingInfo());
		model.put("bidList", bidList);
		
		System.out.println("업데이트완료!");
		return "tiles/ViewAuctionItem";
	}
	
	
	
}
