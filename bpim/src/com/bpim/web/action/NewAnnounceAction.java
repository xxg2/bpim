package com.bpim.web.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.bpim.entity.NewsAnnouncement;
import com.bpim.helper.StringTools;
import com.bpim.service.NewsAnnounceService;
import com.bpim.service.NewsAnnounceServiceImpl;

public class NewAnnounceAction extends ActionSupportBase {
	private static final long serialVersionUID = 4274988765242874229L;

	NewsAnnounceService newsAnnounceService = new NewsAnnounceServiceImpl();

	private List<NewsAnnouncement> newsAnnounces;
	private Long id;
	private String title;
	private String content;
	private Timestamp addTime;
	private Timestamp addTimeTemp;

	public Timestamp getAddTimeTemp() {
		return addTimeTemp;
	}

	public void setAddTimeTemp(Timestamp addTimeTemp) {
		this.addTimeTemp = addTimeTemp;
	}

	public String listNewsAnnounces() {
		try {
			newsAnnounces = newsAnnounceService.findAll();
			return SUCCESS;
		} catch (Exception ex) {
			LOG.error("NewAnnounceAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}

	public String getDetailNewsAnnounces() {
		try {
			NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
			ewsAnnounce.setId(StringTools.string2long(
					request.getParameter("id"), 0));
			ewsAnnounce = newsAnnounceService.getNews(ewsAnnounce);
			if (ewsAnnounce != null) {
				setId(ewsAnnounce.getId());
				setTitle(ewsAnnounce.getNewsTitle());
				setContent(ewsAnnounce.getContent());
				setAddTime(ewsAnnounce.getAddTime());
				setAddTimeTemp(ewsAnnounce.getAddTimeTemp());
			}
			return SUCCESS;
		} catch (Exception ex) {
			LOG.error("NewAnnounceAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String insertNewsAnnounces() {
		try {
			NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
			ewsAnnounce.setNewsTitle(title);
			ewsAnnounce.setContent(content);
			newsAnnounceService.insertNews(ewsAnnounce);
			return SUCCESS;
		} catch (Exception ex) {
			LOG.error("NewAnnounceAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}

	public String updateNewsAnnounces() {
		try {
			NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
			ewsAnnounce.setId(id);
			ewsAnnounce.setNewsTitle(title);
			ewsAnnounce.setContent(content);
			newsAnnounceService.updateNews(ewsAnnounce);
			return SUCCESS;
		} catch (Exception ex) {
			LOG.error("NewAnnounceAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String deleteNewsAnnounces() {
		try {
			NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
			ewsAnnounce.setId(id);
			newsAnnounceService.deleteNews(ewsAnnounce);
			return SUCCESS;
		} catch (Exception ex) {
			LOG.error("NewAnnounceAction error: ", ex);
			super.addErrorMsg(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}

	public List<NewsAnnouncement> getNewsAnnounces() {
		return newsAnnounces;
	}

	public void setNewsAnnounces(List<NewsAnnouncement> newsAnnounces) {
		this.newsAnnounces = newsAnnounces;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
}
