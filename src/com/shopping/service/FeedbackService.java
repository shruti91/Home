package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.FeedbackDAO;
import com.shopping.pojo.Customer;
import com.shopping.pojo.Feedback;
import com.shopping.pojo.ItemMaster;
import com.shopping.pojo.OrderMaster;

@Service("feedbackService")
public class FeedbackService {
	
	@Autowired
	public FeedbackDAO feedbackdao;

	public FeedbackDAO getFeedback() {
		return feedbackdao;
	}

	public void setFeedback(FeedbackDAO feedback) {
		this.feedbackdao = feedback;
	}
	
	
	public List<Feedback> getAllFeedback(){
		return feedbackdao.allFeedback();
	}
	
	public void addFeedback(Feedback feedback){
		feedbackdao.addFeedback(feedback);
	}
}
