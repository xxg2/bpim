package com.bpim.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.UserInfo;
import com.bpim.helper.StringTools;
public class JDBCData
{
    
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    try
    {
      //加载启动
      Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
      //设置属性，连接数
      Properties info = new Properties();
      info.setProperty("proxool.maximum-connection-count", "20");
      info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATA");
      //用户名和密码
      info.setProperty("user", "root");
      info.setProperty("password", "root");
      String alias = "test";
      //加载Oracle的启动和URL
      String driverClass = "org.gjt.mm.mysql.Driver";
      String deiverURL = "jdbc:mysql://CGUAN.asiapacific.cpqcorp.net:3306/BPIM";
      String url = "proxool." + alias + ":" + driverClass + ":" +deiverURL;
      //通过组件的方式注册连接
      ProxoolFacade.registerConnectionPool(url,info);
      
      long startTime = System.currentTimeMillis();
		for(int i=0;i<1000;i++) {
			try {
				Connection conn = DriverManager.getConnection(url);
				conn.setAutoCommit(false);		
				Statement st = conn.createStatement();
				ResultSet result = st.executeQuery("select ID, USER_NAME, USER_PASSWORD, REGISTER_DATE, EXPIRE_DATE, EMAIL, COMPANY, PHONE, LAST_PAY_DATE, QUESTION, ANSWER from user_info");
				UserInfo userInfo;
				List<UserInfo> list = new ArrayList<UserInfo>();
				while(result.next()) {
					userInfo = new UserInfo();
					userInfo.setId(result.getLong("ID"));
					userInfo.setUserName(result.getString("USER_NAME"));
					userInfo.setPassword(result.getString("USER_PASSWORD"));
					userInfo.setRegisterDate(result.getTimestamp("REGISTER_DATE"));
					userInfo.setExpireDate(result.getTimestamp("EXPIRE_DATE"));
					userInfo.setEmail(result.getString("EMAIL"));
					userInfo.setCompany(result.getString("COMPANY"));
					userInfo.setPhone(result.getString("PHONE"));
					userInfo.setLastPayDate(result.getTimestamp("REGISTER_DATE"));
					userInfo.setQuestion(result.getString("QUESTION"));
					userInfo.setAnswer(result.getString("ANSWER"));
					list.add(userInfo);
				}
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis()-startTime);
    }catch(Exception e) {}
    }
}