package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartItem implements Serializable {

  /* Private Fields */

  private Item item;
  private int quantity;
  private boolean inStock;
  /* JavaBeans Properties */

  public boolean isInStock() { return inStock; }
  public void setInStock(boolean inStock) { this.inStock = inStock; }

  public Item getItem() { return item; }
  public void setItem(Item item) {
    this.item = item;
  }

  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

	public int getTotalPrice() {
		if (item != null) {
			return item.getPrice() * quantity;
		}
		else {
			return 0;
		}
	}

  /* Public methods */

  public void incrementQuantity() {
    quantity++;
  }
}
