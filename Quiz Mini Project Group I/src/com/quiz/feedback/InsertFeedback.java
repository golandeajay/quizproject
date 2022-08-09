
package com.quiz.feedback;

public class InsertFeedback {
	
	private int userid;
	private String feedback;
	private String rate;

	public InsertFeedback(int userid,String feedback,String rate) {
		super();
		this.userid=userid;
		this.feedback = feedback;
		this.rate = rate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}

}
