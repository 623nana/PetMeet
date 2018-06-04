package com.example.jpetstore.controller;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes({"category", "itemList"})
public class ViewCategoryController { 
	
	private PetStoreFacade petStore;

	@Value("tiles/ViewItemList")
	private String successViewName;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping("/shop/viewCategory.do")
	public String handleRequest(
			@RequestParam("categoryId") String categoryId,
			ModelMap model
			) throws Exception {
		Category category = this.petStore.getCategory(categoryId);
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.petStore.getItemListByCategory(categoryId));
		itemList.setPageSize(4);
		model.put("category", category);
		model.put("itemList", itemList);
		return successViewName;
		
	}

	@RequestMapping("/shop/viewCategory2.do")
	public String handleRequest2(
			@RequestParam("page") String page,
			@ModelAttribute("category") Category category,
			@ModelAttribute("itemList") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {
		if (category == null || itemList == null) {
			throw new IllegalStateException("Cannot find pre-loaded category and product list");
		}
		if ("next".equals(page)) { itemList.nextPage(); }
		else if ("previous".equals(page)) { itemList.previousPage(); }
		return successViewName;
	}
}
