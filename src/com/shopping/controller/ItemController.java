package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shopping.dao.ItemDAO;
import com.shopping.pojo.ItemMaster;
import com.shopping.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController extends MultiActionController{

	@Autowired
	public ItemService itemService;


	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping("/getAllItems")
	public ModelAndView getAllItems(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		List<ItemMaster> list;
		list = itemService.getAllItems();
		System.out.println("List of items is"+list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("Home");
		return mav;
	}
	
	@RequestMapping("/viewAllItemsAdmin")
	public ModelAndView viewAllItemsAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		List<ItemMaster> list;
		list = itemService.getAllItems();
		System.out.println("List of items is"+list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("viewAllItemAdmin");
		return mav;
	}
	
	@RequestMapping("/addItem")
	public ModelAndView addItem(HttpServletRequest request,
			HttpServletResponse response){
		ItemMaster item=new ItemMaster();
		item.setItemName(request.getParameter("txtName"));
		item.setPrice(Integer.parseInt(request.getParameter("txtPrice")));
		item.setStock(Integer.parseInt(request.getParameter("txtStock")));
		item.setItemDescription(request.getParameter("txtDescription"));
		item.setImagePath(request.getParameter("txtImage"));
		
		itemService.addItem(item);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item);
		mav.setViewName("viewAllItemAdmin");
		return mav;
	}
	
	@RequestMapping("/removeItem")
	public ModelAndView removeItem(HttpServletRequest request,
			HttpServletResponse response){
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		itemService.removeItem(itemId);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("item",item);
		mav.setViewName("viewAllItemAdmin");
		return mav;
	}
	
	@RequestMapping("/searchByCategory")
	public ModelAndView searchByCategory(HttpServletRequest request,
			HttpServletResponse response){
		String catName = request.getParameter("cat");
		List<ItemMaster> listItem = itemService.searchByCategory(catName);
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList",listItem);
		mav.setViewName("Home");
		return mav;
	}
	
	/*@RequestMapping("/specifications")
	public ModelAndView specifications(HttpServletRequest request,HttpServletResponse response) {
		
		int itemid=Integer.parseInt(request.getParameter("itemId"));
		
		ItemDAO itemDao = new ItemDAO();
		ItemMaster item=itemDao.searchById(itemid);
		System.out.println("Item is :: "+item);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("Specification");
		return mav;
	}*/
public void addCategory(){
		
	}
	public void removeCtaegory(){
		
	}
	public void viewAllOrders(){
		
	}
	public void dispatchOrders(){
		
	}
	
}
