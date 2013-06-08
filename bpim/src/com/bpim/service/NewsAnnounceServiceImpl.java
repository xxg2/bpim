package com.bpim.service;

import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.dao.NewsAnnounceDAO;
import com.bpim.dao.NewsAnnounceDAOImpl;
import com.bpim.entity.NewsAnnouncement;

public class NewsAnnounceServiceImpl implements NewsAnnounceService {

	private NewsAnnounceDAO newsAnnounceDAO = NewsAnnounceDAOImpl.getInstance();
	
	public List<NewsAnnouncement> findAll() throws Exception {
		DBConnUtil.getConnection();
		List<NewsAnnouncement> NewsAnnounces = newsAnnounceDAO.findAll();
		DBConnUtil.close();
		return NewsAnnounces;
	}
	
	public NewsAnnouncement getNews(NewsAnnouncement newsAnnouncement)
		throws Exception {
		DBConnUtil.getConnection();
		NewsAnnouncement newsAnnouncement1 = newsAnnounceDAO.get(newsAnnouncement);
		DBConnUtil.close();
		return newsAnnouncement1;
		
	}

	public boolean insertNews(NewsAnnouncement newsAnnouncement)
			throws Exception {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean flag = newsAnnounceDAO.save(newsAnnouncement);
		DBConnUtil.close();
		return flag;
	}

	public boolean updateNews(NewsAnnouncement newsAnnouncement)
			throws Exception {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean flag = newsAnnounceDAO.update(newsAnnouncement);
		DBConnUtil.close();
		return flag;
	}

	public boolean deleteNews(NewsAnnouncement newsAnnouncement)
			throws Exception {
		DBConnUtil.getConnection();
		DBConnUtil.startTransaction(true);
		boolean flag = newsAnnounceDAO.delete(newsAnnouncement.getId());
		DBConnUtil.close();
		return flag;
	}
	
}
