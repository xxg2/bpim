package com.bpim.service;

import java.util.List;

import com.bpim.entity.NewsAnnouncement;

public interface NewsAnnounceService {
	List<NewsAnnouncement> findAll() throws Exception;
	public NewsAnnouncement getNews(NewsAnnouncement newsAnnouncement) throws Exception;
	boolean insertNews(NewsAnnouncement newsAnnouncement) throws Exception;
	boolean updateNews(NewsAnnouncement newsAnnouncement) throws Exception;
	boolean deleteNews(NewsAnnouncement newsAnnouncement) throws Exception;
}
