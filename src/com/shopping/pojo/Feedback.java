package com.shopping.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="FEEDBACK")
public class Feedback {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FEEDBACK_ID", length=5)
	private int feedback_id;
	@Column(length=30)
	private String custName;
	@Column(length=30)
	private String emailId;
	
	@Column(name="COMMENTS",length=50)
	String comments;
	
	public int getfeedback_id() {
		return feedback_id;
	}
	public void setfeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Feedback [feedback_id=" + feedback_id + ", custName=" + custName
				+ ", emailId=" + emailId + ", comments=" + comments + "]";
	}
	

}
