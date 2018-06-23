package com.example.jpetstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.AccountForm;
import com.example.jpetstore.controller.SendMessage;
import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Message;
import com.example.jpetstore.domain.Order;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class MessageValidator implements Validator {
	
	@Autowired
	private PetStoreFacade petStore;
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	public boolean supports(Class<?> clazz) {
		return SendMessage.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		SendMessage sendMessage = (SendMessage) obj;
		Message message = sendMessage.getMessage();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message.message", "MESSAGE");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message.receiverId", "RECEIVERID");
		
		if (petStore.getAccount(message.getReceiverId()) == null) {
			errors.rejectValue("message.receiverId", "RECEIVERIDNOTEXIST");
		}
		
		
		
	}


}