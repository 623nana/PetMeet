package com.example.jpetstore.controller;

import static org.hamcrest.CoreMatchers.everyItem;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.DirectOrderValidator;
import com.example.jpetstore.service.OrderValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes({"userSession", "directOrderForm"})
public class DirectOrderController {
	@Autowired
	private PetStoreFacade petStore;
	@Autowired
	private OrderValidator orderValidator;
	@Autowired
	private DirectOrderValidator directOrderValidator;
	
	@ModelAttribute("directOrderForm")
	public DirectOrderForm createOrderForm() {
		return new DirectOrderForm();
	}

	@ModelAttribute("creditCardTypes")
	public List<String> referenceData() {
		ArrayList<String> creditCardTypes = new ArrayList<String>();
		creditCardTypes.add("Visa");
		creditCardTypes.add("MasterCard");
		creditCardTypes.add("American Express");
		return creditCardTypes;			
	}
	
	@RequestMapping("/shop/newDirectOrder.do")
	public String initNewDirectOrder(HttpServletRequest request,
			@ModelAttribute("shipway") String shipway,
			@ModelAttribute("itemId") String itemId,
			@ModelAttribute("directOrderForm") DirectOrderForm directOrderForm
			) throws ModelAndViewDefiningException {
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		System.out.println(shipway);
		System.out.println(shipway.equals("1"));
		System.out.println(shipway.equals("택배거래"));
		// Re-read account from DB at team's request.
			Account account = petStore.getAccount(userSession.getAccount().getUsername());
			
			Item item = new Item();
			item = petStore.getItem(itemId);
			
			System.out.println(item.getGender());
			
//			directOrderForm.getDirectOrder().setItem(item);
			
			directOrderForm.getDirectOrder().initOrder(account, item);
			return "tiles/NewDirectOrderForm";	
	}
	
	@RequestMapping("/shop/newDirectOrderSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("directOrderForm") DirectOrderForm orderForm, 
			BindingResult result) {
		if (orderForm.didShippingAddressProvided() == false) {	
			// from NewOrderForm
			directOrderValidator.validateCreditCard(orderForm.getDirectOrder(), result);
			directOrderValidator.validateBillingAddress(orderForm.getDirectOrder(), result);
			if (result.hasErrors()) return "tiles/NewDirectOrderForm";
			
			if (orderForm.isShippingAddressRequired() == true) {
				orderForm.setShippingAddressProvided(true);
				return "tiles/DirectShippingForm";
			}
			else {			
				return "tiles/ConfirmDirectOrder";
			}
		}
		else {		// from ShippingForm
			directOrderValidator.validateShippingAddress(orderForm.getDirectOrder(), result);
			if (result.hasErrors()) return "tiles/DirectShippingForm";
			return "tiles/ConfirmDirectOrder";
		}
	}
	
	@RequestMapping("/shop/confirmDirectOrder.do")
	protected ModelAndView confirmOrder(
			@ModelAttribute("directOrderForm") DirectOrderForm directOrderForm, 
			SessionStatus status) {

		petStore.insertDirectOrder(directOrderForm.getDirectOrder());
		ModelAndView mav = new ModelAndView("ViewDirectOrder");
		mav.addObject("order", directOrderForm.getDirectOrder());
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return mav;
	}
	
	@RequestMapping("/shop/newDirectOrderNoShip.do")
	public String initNewDirectOrderNoShip(HttpServletRequest request,
			@ModelAttribute("itemId") String itemId,
			@ModelAttribute("userId") String userId,
			@ModelAttribute("directOrderForm") DirectOrderForm directOrderForm
			) throws ModelAndViewDefiningException {
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		// Re-read account from DB at team's request.
			Account account = petStore.getAccount(userSession.getAccount().getUsername());
			
			Item item = new Item();
			item = petStore.getItem(itemId);
			
			System.out.println("나와랏"+item.getUsername());
			
//			directOrderForm.getDirectOrder().setItem(item);
			
			directOrderForm.getDirectOrder().initOrder(account, item); //얘를해야하나... 다이렉트면 주소는 어쩔??
			return "tiles/NewDirectOrderNoShip";	
	}
	
//	
//	@RequestMapping("/shop/directOrder.do")
//	public String initNewOrder(HttpServletRequest request,
//			@ModelAttribute("itemId") String itemId,
//			@ModelAttribute("directOrderForm") DirectOrderForm directOrderForm
//			) throws ModelAndViewDefiningException {
//			System.out.println(itemId);
//			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
//
//			Account account = petStore.getAccount(userSession.getAccount().getUsername());
//			Cart cart = new Cart();
//			cart.setQuantityByItemId(itemId, 1);
//			
//			directOrderForm.getOrder().initOrder(account, cart);
//			
//			return "DirectOrderForm";
//	}
	
}
