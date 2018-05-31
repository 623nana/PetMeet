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
  private String category = "dog";
  private String gender = "female";
  private String image;
  private Product product;
  private String species;
  private double price;
  private String content;

  public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getSpecies() {
	return species;
}
public void setSpecies(String species) {
	this.species = species;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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