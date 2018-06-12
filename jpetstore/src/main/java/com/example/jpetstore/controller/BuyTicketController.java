package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.domain.Ticket;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/buyTicket.do")
public class BuyTicketController {

	@Autowired
	private PetStoreFacade petStore;
	
	@Value("tiles/BuyTicket")
	private String formViewName;
	//@Value("NewOrderForm")
	@Value("index")
	private String successViewName;
		
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@ModelAttribute("buyTicketForm")
	public BuyTicketForm formBackingObject(HttpServletRequest request) throws Exception {
		return new BuyTicketForm();
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String onSubmit(
//			HttpServletRequest request, HttpSession session,
//			@ModelAttribute("buyTicketForm") BuyTicketForm buyTicketForm,
//			BindingResult result) throws Exception {
//		try {
//			//petStore.buyTicket(buyTicketForm.getAccount().getUsername(), amount);
//			//System.out.println(buyTicketForm.getAccount().getUsername());
////			System.out.println("바보");
//			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//			Account account = petStore.getAccount(userSession.getAccount().getUsername());
//			
////			String username = account.getUsername();
////			System.out.println("끼룩");
////			System.out.println(username);
////			System.out.println(account.getMyticket());
//			
//			int ticket = Integer.parseInt(request.getParameter("Ticket"));	
//			int ticketCost = 0;
//			System.out.println("입력티켓: " + ticket);
//			
////			int originTicket = account.getMyticket();	
////			System.out.println(originTicket);
//			
//			buyTicketForm.getAccount().setMyticket(ticket);
//			
//			System.out.println("계정에 저장된 티켓: " + buyTicketForm.getAccount().getMyticket());	
//		
//			if(ticket == 1) ticketCost = 1000;
//			else if(ticket == 3) ticketCost = 2500;
//			else if(ticket == 5) ticketCost = 4000;			
//			
//			
//			System.out.println(account.getUsername());	
//			System.out.println("티켓" + ticket);	
//			System.out.println(ticketCost);	
//
//			buyTicketForm.getTicket().setUsername(account.getUsername());
//			buyTicketForm.getTicket().setBuyTicketNum(ticket);
//			buyTicketForm.getTicket().setBuyTicketCost(ticketCost);			
//			
//			petStore.insertBuyTicket(buyTicketForm.getTicket());
//			System.out.println("durl");	
//			System.out.println("username: " + buyTicketForm.getTicket().getUsername());
//			System.out.println("ticketcost: " + buyTicketForm.getTicket().getBuyTicketCost());
//			System.out.println("ticketnum: " + buyTicketForm.getTicket().getBuyTicketNum());
//			
//		}
//		catch (DataIntegrityViolationException ex) {			
//			return formViewName;
//		}
//		catch (NullPointerException ex) {			
//			return formViewName;
//		}
//		catch (NumberFormatException ex) {
//			return formViewName;
//		}
//		
//		
//		
//		return "/shop/ticketOrder.do";
//		//return successViewName;
//		}		
	}
		
	

