package com.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shopping.dao.ItemDAO;
import com.shopping.pojo.ItemMaster;
import com.shopping.service.CartService;
import com.shopping.service.ItemService;

@Controller
@RequestMapping("/cart")
public class CartController extends MultiActionController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemDAO itemDao;
	
	public ItemDAO getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	public CartService getCartService() {
		return cartService;
	}

	@Autowired
	public ItemService itemService;


	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	@RequestMapping("/addToCart")
	public ModelAndView addToCart(HttpServletRequest request,
			HttpServletResponse response) {
		
		int itemid=Integer.parseInt(request.getParameter("itemId"));
		System.out.println("Item id is :: "+itemid);
		ItemMaster item=itemDao.searchById(itemid);
		System.out.println("Item is :: "+item);
		cartService.addToCart(item, 1);
		List<ItemMaster> list = itemService.getAllItems();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("Home");
		return mav;
	}
	
	@RequestMapping("/viewAllCart")
	public ModelAndView viewAllCart(HttpServletRequest request,
			HttpServletResponse response) {
		int quantity;
		Map<ItemMaster,Integer> cartItemMap = cartService.viewAllCart();
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartItemMap", cartItemMap);
		mav.setViewName("viewCart");
		return mav;
	}
	
	@RequestMapping("/removeCart")
	public ModelAndView removeCart(HttpServletRequest request,
			HttpServletResponse response) {
		int itemid=Integer.parseInt(request.getParameter("itemId"));
		System.out.println("Item id is :: "+itemid);
		ItemMaster item=itemDao.searchById(itemid);
		System.out.println("Item is :: "+item);
		cartService.removeCart(item);
		Map<ItemMaster,Integer> cartItemMap = cartService.viewAllCart();
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartItemMap", cartItemMap);
		mav.setViewName("viewCart");
		return mav;
	}
	
	@RequestMapping("/checkOut")
	public ModelAndView checkOut(HttpServletRequest request,HttpServletResponse response) {
		int quantity;
		Map<ItemMaster,Integer> cartItemMap = cartService.viewAllCart();
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartItemMap", cartItemMap);
		mav.setViewName("viewCart");
		return mav;
	}
}
