package com.example.jpetstore.controller;

import org.springframework.beans.support.PagedListHolder;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class SearchItemListController { 
	
	private PetStoreFacade petStore;

	@Value("tiles/SearchItemList")
	private String successViewName;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping(value = "/shop/searchItem.do", method=RequestMethod.POST)
	public String handleRequest(HttpServletRequest request,
			@RequestParam(value="searchOption") String searchOption,
			@RequestParam(value="keyword") String keyword,
			ModelMap model) throws Exception {
		List<Item> searchItemList;
		if (searchOption.equals("species")) {
			searchItemList = petStore.getItemListBySpecies(keyword);
		}
		else {
			searchItemList = petStore.getItemListByUserId(keyword);
		}
		model.put("searchItemList", searchItemList);
		return successViewName;
	}
}