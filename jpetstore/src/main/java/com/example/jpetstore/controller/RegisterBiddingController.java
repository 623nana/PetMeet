package com.example.jpetstore.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/registerBidding.do")
public class RegisterBiddingController {

	@Value("tiles/index")
	private String successViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(HttpServletRequest request,
			@RequestParam(value="expectPrice", required=false) String expectPrice,
			@RequestParam(value="itemId", required=false) String itemId
			) throws Exception {
		
		
		System.out.println(expectPrice);
		System.out.println(itemId);
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		BiddingInfo bidInfo = new BiddingInfo();
		
		bidInfo.setItemId(itemId);
		bidInfo.setExpectPrice(Integer.parseInt(expectPrice));
		bidInfo.setUsername(account.getUsername());
		
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ( );
		String biddingTime = formatter.format ( currentTime );
		
		bidInfo.setBiddingTime(biddingTime);
		
		petStore.insertBid(bidInfo);


		
		return successViewName;
	}
	
	
}
