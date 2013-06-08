package com.bpim.entity;

import java.sql.Timestamp;

public class NewsAnnouncement extends VoBase {
	private static final long serialVersionUID = 5066555084924544371L;

	private Long id;
	private String newsTitle;
	private String content;
	private Timestamp addTime;
	private Timestamp addTimeTemp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	public Timestamp getAddTimeTemp() {
		return addTimeTemp;
	}
	public void setAddTimeTemp(Timestamp addTimeTemp) {
		this.addTimeTemp = addTimeTemp;
	}
	
}
