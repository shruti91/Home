package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService catService;

	public CategoryService getCatService() {
		return catService;
	}

	public void setCatService(CategoryService catService) {
		this.catService = catService;
	}
	
	@RequestMapping("/addCategory")
	public ModelAndView addCategory(HttpServletRequest request,
			HttpServletResponse response) {
		String catName = request.getParameter("categoryName");
			catService.addCategory(catName);
				
		ModelAndView mav = new ModelAndView();
		//mav.addObject("", );
		mav.setViewName("Index");
		return mav;
	}
}
