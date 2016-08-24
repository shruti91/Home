package com.shopping.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;


@Entity
@Table(name="CATEGORY")
public class Category {
	@Id
	private int categoryId;
	@Column(length=30)
	private String categoryName;
	
	@OneToMany
	
	private Set<ItemMaster> item;
	
	public Set<ItemMaster> getItem() {
		return item;
	}
	public void setItem(Set<ItemMaster> item) {
		this.item = item;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
