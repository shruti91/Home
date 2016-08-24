package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryDAO;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO catDao;
	
	
	public CategoryDAO getCatDao() {
		return catDao;
	}
	public void setCatDao(CategoryDAO catDao) {
		this.catDao = catDao;
	}
	public void addCategory(String catName){
		catDao.addCategory(catName);
	}
	
}
