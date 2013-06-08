package com.bpim.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBConnUtil {
	private static Connection conn;
	
	private DBConnUtil() {}
	
	//DataSource是DBCP的数据库连接池
	private static BasicDataSource ds=null;
	//既然是工具类，那就是拿来就能用的，不用new它
	//这个静态代码块确保其内容只运行一次，这里在第一次调用的时候，获取一个工厂
	static{
		try{
			//读取资源文件
			InputStream stream = DBConnUtil.class.getClassLoader().getResourceAsStream("dbconn.properties");   
            Properties props = new Properties();
            props.load(stream);
			//通过这个工厂，我们获得一个根据资源文件配置的数据库连接池
			ds = (BasicDataSource) BasicDataSourceFactory.createDataSource(props);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//返回一个数据库连接
	public static Connection getConnection() throws SQLException{
		conn = ds.getConnection();
		return conn;
	}   
	
	public static ResultSet getStatement(String sql) throws SQLException {
		Statement stet = conn.createStatement();
		return stet.executeQuery(sql);
	}
	
	public static PreparedStatement getPrepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}
	
	public static void startTransaction(boolean isAutoCommit) throws SQLException {
		conn.setAutoCommit(isAutoCommit);
	}
	
	public static void endTransaction() throws SQLException {
		conn.commit();
	}
	
	public static void close() throws SQLException {
		if(conn!=null && !conn.isClosed()) {
			conn.close();
		}
	}
}