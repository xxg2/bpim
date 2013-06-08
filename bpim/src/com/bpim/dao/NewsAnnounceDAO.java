package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.NewsAnnouncement;

public interface NewsAnnounceDAO {
	List<NewsAnnouncement> findAll() throws SQLException;

	NewsAnnouncement get(NewsAnnouncement newsAnnouncement) throws SQLException;

	boolean save(NewsAnnouncement newsAnnouncement) throws SQLException;

	boolean update(NewsAnnouncement newsAnnouncement) throws SQLException;

	boolean delete(Long id) throws SQLException;
}
