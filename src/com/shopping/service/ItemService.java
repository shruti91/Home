package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.ItemDAO;
import com.shopping.pojo.ItemMaster;

@Service("itemservice")
public class ItemService {
	
	@Autowired
	public ItemDAO dao;
	
	public ItemDAO getDao() {
		return dao;
	}
	public void setDao(ItemDAO dao) {
		this.dao = dao;
	}
	public List<ItemMaster> getAllItems(){
		 return dao.getAllItems();
	}
	public void addItem(ItemMaster item){
		dao.addItems(item);
	}
	
	public void removeItem(int itemId){
		dao.removeItem(itemId);
	}
	
	public List<ItemMaster> searchByCategory(String catName){
		return dao.searchByCategory(catName);
	}
	
}
