package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.AccountFormValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/surveyResult.do")
public class RecommendPetController { 

	@Value("tiles/SurveyResult")
	private String successViewName;
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
//	@ModelAttribute("surveyResult")
//	public SurveyResult formBackingObject(HttpServletRequest request)
//			throws Exception {
//		System.out.println("formBacking2");
//		return new SurveyResult();
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@RequestParam(value = "q1") String q1, @RequestParam(value = "q2") String q2,
			@RequestParam(value = "q3") String q3, @RequestParam(value = "q4") String q4,
			@RequestParam(value = "q5") String q5, @RequestParam(value = "q6") String q6,
			@RequestParam(value = "q7") String q7, ModelMap model) throws Exception {
		
		System.out.println("submit≈¨∏Ø");
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		String username = userSession.getAccount().getUsername();
		SurveyResult surveyResult = new SurveyResult();
		int[] answer = new int[3];
		for (int i = 0; i < answer.length; i ++) {
			answer[i] = 0;
		}

		if (q1.equals("a")) answer[0] ++;
		else if (q1.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		if (q2.equals("a")) answer[0] ++;
		else if (q2.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		if (q3.equals("a")) answer[0] ++;
		else if (q3.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		if (q4.equals("a")) answer[0] ++;
		else if (q4.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		if (q5.equals("a")) answer[0] ++;
		else if (q5.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		if (q6.equals("a")) answer[0] ++;
		else if (q6.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		if (q7.equals("a")) answer[0] ++;
		else if (q7.equals("b")) answer[1] ++;
		else answer[2] ++;
		
		int max = answer[0];
		for (int i = 0; i < answer.length; i ++) {
			if (answer[i] > max)
				max = answer[i];
		}
		surveyResult.setUsername(username);
		if (max == answer[0]) {
			surveyResult.setSurveyResult("A type");
		}
		else if (max == answer[1]) {
			surveyResult.setSurveyResult("B type");
		}
		else {
			surveyResult.setSurveyResult("C type");
		}
		System.out.println(surveyResult.getSurveyResult());
		
		model.put("result", surveyResult);
		return successViewName;
	}
}
	