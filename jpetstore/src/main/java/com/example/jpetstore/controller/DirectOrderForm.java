package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Order;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 */
@SuppressWarnings("serial")
public class DirectOrderForm implements Serializable {

	private final Order directOrder = new Order();
	public Order getDirectOrder() {
		return directOrder;
	}

	private boolean shippingAddressRequired = false;
	private boolean shippingAddressProvided = false;

	
	public void setShippingAddressRequired(boolean shippingAddressRequired) {
		this.shippingAddressRequired = shippingAddressRequired;
	}

	public boolean isShippingAddressRequired() {
		return shippingAddressRequired;
	}

	public void setShippingAddressProvided(boolean shippingAddressProvided) {
		this.shippingAddressProvided = shippingAddressProvided;
	}

	public boolean didShippingAddressProvided() {
		return shippingAddressProvided;
	}
}
