package com.quiz.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_report")
public class Report {
	
	@Id
	@Column(name = "Report_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long reportId;
	
	@Column(name = "User_Id")
	private long userId;
	
	@Column(name = "Topic_Name")
	private String topicName;
	
	@Column(name = "Score")
	private long score;
	
	@Column(name = "Feedback")
	private String feedBack;

	/**
	 * 
	 */
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Report(long reportId, long userId, String topicName, long score, String feedBack) {
		super();
		this.reportId = reportId;
		this.userId = userId;
		this.topicName = topicName;
		this.score = score;
		this.feedBack = feedBack;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	
	

}
