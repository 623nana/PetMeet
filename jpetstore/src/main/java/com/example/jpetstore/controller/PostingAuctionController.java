package com.example.jpetstore.controller;

import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.service.MessageValidator;
import com.example.jpetstore.service.PetStoreFacade;
import com.example.jpetstore.service.PostingAuctionItemValidator;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/postAuctionItem.do")
public class PostingAuctionController {

	@Value("tiles/PostingAuctionItem")
	private String formViewName;
	@Value("tiles/index")
	private String successViewName;
	@Value("tiles/PostingError")
	private String errorViewName;
	
	@Autowired
	private PostingAuctionItemValidator postingValidator;
	public void setValidator(PostingAuctionItemValidator validator) {
		this.postingValidator = validator;
	}
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("postingAuction")
	public PostingAuction formBackingObject(HttpServletRequest request,
			@Param("itemId") String itemId)
			throws Exception {
		if(itemId!= null)
			return new PostingAuction(
					petStore.getAuctionItem(itemId));
		else
			return new PostingAuction();
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
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@RequestParam("file") MultipartFile file,
			@ModelAttribute("postingAuction") PostingAuction postingAuction,
			BindingResult result) throws Exception {
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		postingValidator.validate(postingAuction, result);
		if(result.hasErrors()) return formViewName;
		
		try {
			if(postingAuction.isNewPosting()) {
				System.out.println("insert");
				
				//파일명 중복 오류를 없애기 위한
				UUID uuid = UUID.randomUUID();
				
		        String saveName = uuid.toString()+"_" + file.getOriginalFilename();

		        //본인 파일 경로로 바꿔주기
		        String savePath = "C:\\Users\\dain\\git\\PetMeet\\jpetstore\\src\\main\\webapp\\images\\";
		        
		        FileOutputStream target = new FileOutputStream(savePath + saveName);
		        
		        FileCopyUtils.copy(file.getBytes(), target);
		        
		        target.flush();
		        target.close();
		        
				Account account = petStore.getAccount(userSession.getAccount().getUsername());
				
				String str = postingAuction.getAuctionItem().getTime();
				
				System.out.println(str);
				
				postingAuction.getAuctionItem().getItem().setImage(saveName);
				
				String id = petStore.setProductId(postingAuction.getAuctionItem().getItem().getName());
				
				if(id == null) { //사용자가 입력한 종의 Product ID가 존재하지 않는 경우
					System.out.println("없음");
					petStore.insertNewProduct(postingAuction.getAuctionItem().getItem());	
					String newId = petStore.setProductId(postingAuction.getAuctionItem().getItem().getName());
					postingAuction.getAuctionItem().getItem().setProductId(newId);
					postingAuction.getAuctionItem().getItem().setUsername(account.getUsername());
					
					petStore.insertAuctionItem(postingAuction.getAuctionItem().getItem());
					postingAuction.getAuctionItem().setItemId(postingAuction.getAuctionItem().getItem().getItemId());
					petStore.insertAuctionInfo(postingAuction.getAuctionItem());
					
				} else {
					System.out.println("넣었음");
					postingAuction.getAuctionItem().getItem().setProductId(id);
					postingAuction.getAuctionItem().getItem().setUsername(account.getUsername());
					petStore.insertAuctionItem(postingAuction.getAuctionItem().getItem());
					postingAuction.getAuctionItem().setItemId(postingAuction.getAuctionItem().getItem().getItemId());
					petStore.insertAuctionInfo(postingAuction.getAuctionItem());
				}
				
			}else {
				petStore.updateAuctionItem(postingAuction.getAuctionItem().getItem());
			}
				
			
		}
		catch (DataIntegrityViolationException ex) {
			System.out.println("오류");
			result.rejectValue("item.image", "IMAGE_ERROR");
			return formViewName;
			}

		 petStore.useTicket(userSession.getAccount().getUsername());
		 return successViewName;
		}
	
	}
		
	