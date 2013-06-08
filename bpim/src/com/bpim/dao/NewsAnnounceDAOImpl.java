package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.NewsAnnouncement;

public class NewsAnnounceDAOImpl implements NewsAnnounceDAO {

	private static String FINDALLSQL = "SELECT ID, NEWS_TITLE, NEWS_CONTENT, ADD_TIME FROM NEWS_ANNOUNCEMENT ORDER BY ADD_TIME DESC";
	private static String GETSQL = "SELECT ID, NEWS_TITLE, NEWS_CONTENT, ADD_TIME FROM NEWS_ANNOUNCEMENT WHERE ID = ?";
	private static String SAVESQL = "INSERT INTO NEWS_ANNOUNCEMENT(NEWS_TITLE, NEWS_CONTENT, ADD_TIME) VALUES(?, ?, now())";
	private static String UPDATESQL = "UPDATE NEWS_ANNOUNCEMENT SET NEWS_TITLE = ?, NEWS_CONTENT = ? WHERE ID = ?";
	private static String DELETESQL = "DELETE FROM NEWS_ANNOUNCEMENT WHERE ID = ?";
	
	private static NewsAnnounceDAOImpl newsAnnounceDAOImpl = new NewsAnnounceDAOImpl();
	public static NewsAnnounceDAOImpl getInstance() {
		return newsAnnounceDAOImpl;
	}

	private NewsAnnounceDAOImpl() {
	}
	
	public List<NewsAnnouncement> findAll() throws SQLException {
		ResultSet result = DBConnUtil.getStatement(FINDALLSQL);
		NewsAnnouncement newsAnnouncement;
		List<NewsAnnouncement> list = new ArrayList<NewsAnnouncement>();
		while (result.next()) {
			newsAnnouncement = new NewsAnnouncement();
			newsAnnouncement.setId(result.getLong("ID"));
			newsAnnouncement.setNewsTitle(result.getString("NEWS_TITLE"));
			newsAnnouncement.setContent(result.getString("NEWS_CONTENT"));
			newsAnnouncement.setAddTime(result.getTimestamp("ADD_TIME"));
			newsAnnouncement.setAddTimeTemp(result.getTimestamp("ADD_TIME"));
			list.add(newsAnnouncement);
		}
		return list;
	}

	public NewsAnnouncement get(NewsAnnouncement newsAnnouncement) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(GETSQL);
		stet.setLong(1, newsAnnouncement.getId());
		ResultSet result = stet.executeQuery();
		while (result.next()) {
			newsAnnouncement.setId(result.getLong("ID"));
			newsAnnouncement.setNewsTitle(result.getString("NEWS_TITLE"));
			newsAnnouncement.setContent(result.getString("NEWS_CONTENT"));
			newsAnnouncement.setAddTime(result.getTimestamp("ADD_TIME"));
			newsAnnouncement.setAddTimeTemp(result.getTimestamp("ADD_TIME"));
			return newsAnnouncement;
		}
		return null;
	}

	public boolean save(NewsAnnouncement newsAnnouncement) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(SAVESQL);
		stet.setString(1, newsAnnouncement.getNewsTitle());
		stet.setString(2, newsAnnouncement.getContent());
		int result = stet.executeUpdate();
		if(result>0) {
			return true;
		}
		return false;
	}

	public boolean update(NewsAnnouncement newsAnnouncement)
			throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(UPDATESQL);
		stet.setString(1, newsAnnouncement.getNewsTitle());
		stet.setString(2, newsAnnouncement.getContent());
		stet.setLong(3, newsAnnouncement.getId());
		int result = stet.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	public boolean delete(Long id) throws SQLException {
		PreparedStatement stet = DBConnUtil.getPrepareStatement(DELETESQL);
		stet.setLong(1, id);
		int result = stet.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}	
}
