package com.example.jpetstore.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.jpetstore.domain.BiddingInfo;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class ViewMyBiddingController { 
	
	private PetStoreFacade petStore;

	@Value("tiles/ViewMyBidding")
	private String successViewName;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping(value = "/shop/viewMyBidding.do")
	public String handleRequest(HttpServletRequest request,
			ModelMap model) throws Exception {
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String username = userSession.getAccount().getUsername();
		System.out.println(username);
		
		List<BiddingInfo> viewMyBidding = petStore.getMyBidding(username);
		model.put("viewMyBidding", viewMyBidding);
		return successViewName;
	}
}