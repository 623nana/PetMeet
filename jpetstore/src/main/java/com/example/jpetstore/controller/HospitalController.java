package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Ticket;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class HospitalController {

	@Value("tiles/Hospital")
	private String formViewName;
	//@Value("NewOrderForm")
	@Value("index")
	private String successViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		return new AccountForm(
				petStore.getAccount(userSession.getAccount().getUsername()));
	}
	
//	@RequestMapping("/shop/viewHospital.do")
//	public String viewHospital(HttpServletRequest request, @ModelAttribute("accountForm") AccountForm accountForm) {
//		
//		System.out.println(accountForm.getAccount().getUsername());
//		System.out.println(accountForm.getAccount().getAddress1() + " " + accountForm.getAccount().getCity());
//		String myaddress = accountForm.getAccount().getCity() + " " + accountForm.getAccount().getAddress1();
//		request.setAttribute("myaddress", myaddress);
//		System.out.println("저장" + request.getAttribute(myaddress));
//		System.out.println("마이더르세"+ myaddress);
//		return "tiles/Hospital";
//	}
	
	@RequestMapping("/shop/viewHospital.do")
	protected ModelAndView confirmTicketOrder(
			HttpServletRequest request, @ModelAttribute("accountForm") AccountForm accountForm)
	{	
		String myaddress = accountForm.getAccount().getCity() + " " + accountForm.getAccount().getAddress1() + " 동물병원";
		
		ModelAndView mav = new ModelAndView("tiles/Hospital");
		mav.addObject("myaddress", myaddress);
		
		return mav;
	}

}
		
	

