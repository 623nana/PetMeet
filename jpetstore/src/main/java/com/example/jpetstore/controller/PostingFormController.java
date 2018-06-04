package com.example.jpetstore.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/postItem.do")
public class PostingFormController {

	@Value("tiles/PostingFixedItem")
	private String formViewName;
	@Value("tiles/index")
	private String successViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("postingForm")
	public PostingForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		System.out.println("formBacking");
		return new PostingForm();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@RequestParam("file") MultipartFile file,
			@ModelAttribute("postingForm") PostingForm postingForm,
			BindingResult result) throws Exception {
		
		if(result.hasErrors()) return formViewName;
		try {
			if(postingForm.isNewPosting()) {
				System.out.println("insert");
				UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
				
				//파일명 중복 오류를 없애기 위한
				UUID uuid = UUID.randomUUID();
				
		        String saveName = uuid.toString()+"_" + file.getOriginalFilename();
		        
		        //본인 파일 경로로 바꿔주기
		        String savePath = "C:\\Users\\HyeonJeong\\git\\PetMeet\\jpetstore\\src\\main\\webapp\\images";
		        
		        File target = new File(savePath, saveName);
		        
		        FileCopyUtils.copy(file.getBytes(), target);

				Account account = petStore.getAccount(userSession.getAccount().getUsername());
				
				String id = petStore.setProductId(postingForm.getItem().getName());
				
				postingForm.getItem().setImage(saveName);
				
				System.out.println(id);
				if(id == null) { //사용자가 입력한 종의 Product ID가 존재하지 않는 경우
					System.out.println("없음");
					petStore.insertNewProduct(postingForm.getItem());	
					String newId = petStore.setProductId(postingForm.getItem().getName());
					postingForm.getItem().setProductId(newId);
					postingForm.getItem().setUsername(account.getUsername());
					petStore.insertFixedItem(postingForm.getItem());
					
				} else {
					postingForm.getItem().setProductId(id);
					postingForm.getItem().setUsername(account.getUsername());
					petStore.insertFixedItem(postingForm.getItem());
				}
				
			}
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("오류");
			return formViewName;
			}
		
		 return successViewName;
		}
	
	

		
	}
		
	


