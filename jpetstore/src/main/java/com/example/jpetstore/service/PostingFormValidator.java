package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.jpetstore.controller.PostingForm;
import com.example.jpetstore.domain.Item;
/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class PostingFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return PostingForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		PostingForm postingForm = (PostingForm) obj;
		Item item = postingForm.getItem();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.name", "ITME_NAME_REQUIRED");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.price", "ITEM_PRICE_REQUIRED");
		
		if(item.getPrice() == 0) {
			errors.rejectValue("item.price", "ITEM_PRICE_ERROR");			
		}
	
		
	}
}