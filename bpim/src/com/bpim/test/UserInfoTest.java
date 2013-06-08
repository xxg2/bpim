package com.bpim.test;

import java.sql.SQLException;
import java.util.List;

import com.bpim.dao.UserInfoDAO;
import com.bpim.dao.UserInfoDAOImpl;
import com.bpim.entity.UserInfo;

public class UserInfoTest {	
	public String sayHello(String userName) {
		return userName+" 您好!服务器时间是:"+System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		UserInfoDAO infoDAO = UserInfoDAOImpl.getInstance();
		try {
			List<UserInfo> list = infoDAO.findAll();
			UserInfo userInfo = new UserInfo();
			if(list != null && list.size() > 0) {
				System.out.println(list.size());
				for(int i=0; i<list.size(); i++) {
					userInfo = list.get(i);
					System.out.println(userInfo.getUserName());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
