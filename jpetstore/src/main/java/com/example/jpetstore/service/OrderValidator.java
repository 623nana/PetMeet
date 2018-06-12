package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.domain.Order;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class OrderValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Order.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
//		OrderForm orderForm = (OrderForm) obj;
//		
//		validateCreditCard((Order) orderForm.getOrder(), errors);
//		validateBillingAddress((Order) orderForm.getOrder(), errors);
//		validateShippingAddress((Order) orderForm.getOrder(), errors);
		validateCreditCard((Order) obj, errors);
		validateBillingAddress((Order) obj, errors);
		validateShippingAddress((Order) obj, errors);
	}

	public void validateCreditCard(Order order, Errors errors) {
		errors.setNestedPath("order");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creditCard", "CCN_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryDate", "EXPIRY_DATE_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardType", "CARD_TYPE_REQUIRED");
		errors.setNestedPath("");
	}

	public void validateBillingAddress(Order order, Errors errors) {
		errors.setNestedPath("order");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billToFirstName", "BILL_FIRST_NAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billToLastName", "BILL_LAST_NAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billAddress1", "BILL_ADDRESS_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billCity", "BILL_CITY_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billState", "BILL_STATE_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billZip", "BILL_ZIP_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billCountry", "BILL_COUNTRY_REQUIRED");
		errors.setNestedPath("");
	}

	public void validateShippingAddress(Order order, Errors errors) {
		errors.setNestedPath("order");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipToFirstName", "SHIP_FIRST_NAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipToLastName", "SHIP_LAST_NAME_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress1", "SHIP_ADDRESS_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipCity", "SHIP_CITY_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipState", "SHIP_STATE_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipZip", "SHIP_ZIP_REQUIRED");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipCountry", "SHIP_COUNTRY_REQUIRED");
		errors.setNestedPath("");
	}
}