package com.example.jpetstore.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.PetStoreFacade;
import com.example.jpetstore.service.PostingFormValidator;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/postItem.do")
public class PostingFormController {

	@Value("tiles/PostingFixedItem")
	private String formViewName;
	@Value("tiles/index")
	private String successViewName;
	@Value("tiles/PostingError")
	private String errorViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("postingForm")
	public PostingForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		return new PostingForm();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request) {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Account account = petStore.getAccount(userSession.getAccount().getUsername());
		
		int myticket = petStore.getMyTicketByUsername(account.getUsername());
		if(myticket == 0) {
			return errorViewName;
		}
		else {
			return formViewName;
		}
	}
	
	@Autowired
	private PostingFormValidator validator;
	public void setValidator(PostingFormValidator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("postingForm") PostingForm postingForm,
			BindingResult result) throws Exception {
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		validator.validate(postingForm, result);
		if(result.hasErrors()) return formViewName;
		
		try {
			if(postingForm.isNewPosting()) {
				System.out.println("insert");
				
				//���ϸ� �ߺ� ������ ���ֱ� ����
				UUID uuid = UUID.randomUUID();
				
		        String saveName = uuid.toString()+"_" + file.getOriginalFilename();
		        //ServletContext context = request.getSession().getServletContext();

		        //���� ���� ��η� �ٲ��ֱ�
		        String savePath = //context.getRealPath("/images/");
		        		"C:\\Users\\����\\git\\PetMeet\\jpetstore\\src\\main\\webapp\\images\\";
		        
//		        BufferedOutputStream stream = new BufferedOutputStream(
//		        		new FileOutputStream(new File(savePath + saveName)));
		        
		        System.out.println(savePath + saveName);
		        
//		        stream.write(file.getBytes());
//		        stream.flush();
//		        stream.close();
		        
		        FileOutputStream target = new FileOutputStream(savePath + saveName);
		        
		        FileCopyUtils.copy(file.getBytes(), target);
		        
//		        target.flush();
		        target.close();
		        
				Account account = petStore.getAccount(userSession.getAccount().getUsername());
				
				String id = petStore.setProductId(postingForm.getItem().getName());
				
				postingForm.getItem().setImage(saveName);
				
				System.out.println(id);
				if(id == null) { //����ڰ� �Է��� ���� Product ID�� �������� �ʴ� ���
					System.out.println("����");
					petStore.insertNewProduct(postingForm.getItem());	
					String newId = petStore.setProductId(postingForm.getItem().getName());
					postingForm.getItem().setProductId(newId);
					postingForm.getItem().setUsername(account.getUsername());
					petStore.insertFixedItem(postingForm.getItem());
					petStore.insertInventory(postingForm.getItem());
					
				} else {
					System.out.println("�־���");
					postingForm.getItem().setProductId(id);
					postingForm.getItem().setUsername(account.getUsername());
					petStore.insertFixedItem(postingForm.getItem());
					petStore.insertInventory(postingForm.getItem());
				}
				
			}
				
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("����");
			result.rejectValue("item.image", "IMAGE_ERROR");
			return formViewName;
		}
		 petStore.useTicket(userSession.getAccount().getUsername());
		 return successViewName;
		}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new PostingFormValidator());
//	}

		
	}
		
	