package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
  /* Private Fields */
  private String itemId;
  private String productId;
  private int supplierId;
  private String username;
  private String status;
  private int shipway;
  private String categoryId;
  private String gender;
  private String image;
  private Product product;
  private String name;
  private int price;
  private String content;

  public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
	/* JavaBeans Properties */
	public String getItemId() { return itemId; }
	public void setItemId(String itemId) { this.itemId = itemId.trim(); }
		
	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }
		
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId = productId; }


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getShipway() {
		return shipway;
	}
	public void setShipway(int shipway) {
		this.shipway = shipway;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getSupplierId() { return supplierId; }
	public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

  public String toString() {
    return "(" + getItemId().trim() + "-" + getProductId().trim() + ")";
  }
}