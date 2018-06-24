package com.example.jpetstore.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.PostingAuction;
import com.example.jpetstore.controller.PostingForm;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.Item;
/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class PostingAuctionItemValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return PostingAuction.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		PostingAuction postingAuction = (PostingAuction) obj;
		AuctionItem item = postingAuction.getAuctionItem();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.item.name", "ITME_NAME_REQUIRED");
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.item.content", "ITEM_CONTENT_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.time", "ITEM_TIME_REQUIRED");
		
		if (item.getBeginPrice() == 0)
			errors.rejectValue("auctionItem.beginPrice", "ITEM_BEGIN_PRICE_REQUIRED");
		if (item.getLimitPrice() == 0)
			errors.rejectValue("auctionItem.limitPrice", "ITEM_LIMIT_PRICE_REQUIRED");
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern ("uuuu-MM-dd HH:mm");
		try {
		    LocalDate ld = LocalDate.parse ( item.getTime().toString() , f );
		    System.out.println ( "¸ÂÀ½" + ld );
		} catch ( DateTimeParseException e ) {
			errors.rejectValue("auctionItem.time", "ITEM_TIME_FORMAT");
		}
		
		
	}
}