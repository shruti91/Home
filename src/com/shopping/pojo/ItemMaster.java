package com.shopping.pojo;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class ItemMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	@Column(length=30)
	private String itemName;
	private double price;
	private int stock;
	@Column(length=50)
	private String itemDescription;
	@Column(length=100)
	private String imagePath;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	
	/*@ElementCollection
	private Map<String, String> specification;
	
	public Map<String, String> getSpecification() {
		return specification;
	}
	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}*/
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "ItemMaster [itemId=" + itemId + ", itemName=" + itemName
				+ ", price=" + price + ", stock=" + stock
				+ ", itemDescription=" + itemDescription + ", imagePath="
				+ imagePath + "]";
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMaster other = (ItemMaster) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}
}
