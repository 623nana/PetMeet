package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Ticket;
import com.example.jpetstore.service.OrderValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("orderForm")
public class OrderController {
	@Autowired
	private PetStoreFacade petStore;
	@Autowired
	private OrderValidator orderValidator;
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}

	@ModelAttribute("creditCardTypes")
	public List<String> referenceData() {
		ArrayList<String> creditCardTypes = new ArrayList<String>();
		creditCardTypes.add("Visa");
		creditCardTypes.add("MasterCard");
		creditCardTypes.add("American Express");
		return creditCardTypes;			
	}
	
	@ModelAttribute("dbCart")
	public Cart createCartByDB(HttpSession session) {
		Cart cart = new Cart();		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if(userSession != null) {
			String username = userSession.getAccount().getUsername();
			List<String> itemId = petStore.getCartItemByUsername(username);
			for(String id: itemId) {
				Item item = petStore.getItem(id);
				int qty = petStore.getQtyByItem(item, username);
				boolean isInStock = this.petStore.isItemInStock(id);
				cart.addItem(item, isInStock);
				cart.setQuantityByItemId(item.getItemId(), qty);
			}
		}
		return cart;
	}	
	
	@RequestMapping("/shop/newOrder.do")
	public String initNewOrder(HttpServletRequest request,
			@ModelAttribute("dbCart") Cart dbcart,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (dbcart != null) {
			// Re-read account from DB at team's request.
			Account account = petStore.getAccount(userSession.getAccount().getUsername());
			orderForm.getOrder().initOrder(account, dbcart);
			return "tiles/NewOrderForm";	
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@RequestMapping("/shop/ticketOrder.do")
	public String initNewOrder(HttpServletRequest request,
			@ModelAttribute("buyTicketForm") BuyTicketForm buyTicketForm,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			// Re-read account from DB at team's request.
			Account account = petStore.getAccount(userSession.getAccount().getUsername());
			
			int ticket = Integer.parseInt(request.getParameter("Ticket"));	
			int ticketCost = 0;
			buyTicketForm.getAccount().setMyticket(ticket);
			
			if(ticket == 1) ticketCost = 1000;
			else if(ticket == 3) ticketCost = 2500;
			else if(ticket == 5) ticketCost = 4000;			
			
			buyTicketForm.getTicket().setUsername(account.getUsername());
			buyTicketForm.getTicket().setBuyTicketNum(ticket);
			buyTicketForm.getTicket().setBuyTicketCost(ticketCost);			
			
			petStore.insertBuyTicket(buyTicketForm.getTicket());
			
			orderForm.getOrder().initOrder(account, buyTicketForm.getTicket());
			return "tiles/NewTicketOrderForm";
	}
	
	@RequestMapping("/shop/newOrderSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {
		if (orderForm.didShippingAddressProvided() == false) {	
			// from NewOrderForm
			orderValidator.validateCreditCard(orderForm.getOrder(), result);
			orderValidator.validateBillingAddress(orderForm.getOrder(), result);
//			orderValidator.validate(orderForm.getOrder(), result);
			if (result.hasErrors()) return "tiles/NewOrderForm";
			
			if (orderForm.isShippingAddressRequired() == true) {
				orderForm.setShippingAddressProvided(true);
				return "tiles/ShippingForm";
			}
			else {			
				return "tiles/ConfirmOrder";
			}
		}
		else {		// from ShippingForm
			orderValidator.validateShippingAddress(orderForm.getOrder(), result);
//			orderValidator.validate(orderForm.getOrder(), result);
			if (result.hasErrors()) return "tiles/ShippingForm";
			return "tiles/ConfirmOrder";
		}
	}
	
	@RequestMapping("/shop/newTicketOrderSubmitted.do")
	public String bindAndValidateTicketOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {
		orderValidator.validateCreditCard(orderForm.getOrder(), result);
		if (result.hasErrors()) return "tiles/NewTicketOrderForm";
		return "tiles/ConfirmOrder";
	}
	
	@RequestMapping("/shop/confirmOrder.do")
	protected ModelAndView confirmOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		petStore.insertOrder(orderForm.getOrder());
		ModelAndView mav = new ModelAndView("tiles/ViewOrder");
		mav.addObject("order", orderForm.getOrder());
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		petStore.deleteCartItemByUsername(userSession.getAccount().getUsername());
		return mav;
	}
		
	@RequestMapping("/shop/confirmTicketOrder.do")
	protected ModelAndView confirmTicketOrder(
			HttpServletRequest request,
			@ModelAttribute("buyTicketForm") BuyTicketForm buyTicketForm,
			@ModelAttribute("orderForm") OrderForm orderForm)
	{
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		// Re-read account from DB at team's request.
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		Ticket ticket = petStore.getTicketByUsername(account.getUsername());		
		
		int cost = ticket.getBuyTicketCost();
		
		petStore.buyTicket(ticket);
		petStore.deleteBuyTicketByUsername(ticket);
		int myticket = petStore.getMyTicketByUsername(account.getUsername());
	
		ModelAndView mav = new ModelAndView("tiles/ViewTicketOrder");
		mav.addObject("cost", cost);
		mav.addObject("myticket", myticket);
		mav.addObject("message", "Thank you, your order has been submitted.");
		
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "tiles/Exception";
	}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new OrderValidator());
//	}
}
