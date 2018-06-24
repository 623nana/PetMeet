package com.example.jpetstore.controller.rest;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.service.OrderService;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Changsup Park
 */
@Controller
public class RestfulOrderController {
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping(value = "/item/{categoryId}", method = RequestMethod.GET, 
            produces = "application/json")
	@ResponseBody         
	public List<Item> getOrder(@PathVariable("categoryId") String categoryId, HttpServletResponse response)
			throws IOException {
		System.out.println("/rest/item/{categoryId} request accepted: {categoryId} = " + categoryId);
		List<Item> itemList = this.petStore.getItemListByCategory(categoryId);
		//Order order = this.petStoreSvc.getOrder(orderId);
		if (itemList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return itemList;   // convert order to JSON text in response body
	}
}
	
	

