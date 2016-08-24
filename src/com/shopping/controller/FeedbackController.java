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

import com.shopping.pojo.Customer;
import com.shopping.pojo.Feedback;
import com.shopping.pojo.ItemMaster;
import com.shopping.service.FeedbackService;


@Controller
@RequestMapping("/feedback")
public class FeedbackController extends MultiActionController{
	
	@Autowired
	public FeedbackService feedbackService;

	public FeedbackService getFeedbackService() {
		return feedbackService;
	}

	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	
	@RequestMapping("/custFeedback")
	public ModelAndView custFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		
		Feedback feedback = new Feedback();
		
		feedback.setCustName(request.getParameter("txtUser"));
		feedback.setEmailId(request.getParameter("txtemail"));
		feedback.setComments(request.getParameter("txtcomments"));
		
		feedbackService.addFeedback(feedback);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Index");
		return mav;
	}

	@RequestMapping("/viewFeedback")
	public ModelAndView viewFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Feedback> feedbacklist = feedbackService.getAllFeedback();
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("feedbacklist", feedbacklist);
		mav.setViewName("ViewFeedback");
		return mav;
	}
	
}
