package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.jpetstore.domain.HotItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class ViewHotAuctionController {
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping("/shop/index")
	public String handleRequest(ModelMap model)throws Exception{
		System.out.println("µé¾î¿È");
		List<HotItem> hotItem = petStore.getTopAuction();
		List<Item> item = new ArrayList<Item>();
		
		for(int i = 0; i<hotItem.size(); i++) {
			item.add(petStore.getItem(hotItem.get(i).getItemId()));
		}
		System.out.println("µé¾î¿È");
		model.put("item", item);
		
		return "tiles/index";
	}
}
