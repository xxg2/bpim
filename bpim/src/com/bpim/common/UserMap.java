package com.bpim.common;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserMap {

	private static Log log = LogFactory.getLog(UserMap.class);

	private static UserMap userMap;

	private Map<String, Users> map;

	private ReentrantLock lock;

	private UserMap() {
		map = new HashMap<String, Users>();
		lock = new ReentrantLock();
	}

	public static UserMap getInstance() {
		if (userMap == null) {
			userMap = new UserMap();
		}
		return userMap;
	}

	public void addUser(String sessionId, Users users) {
		if (users != null && !StringUtils.isEmpty(sessionId)) {
			try {
				lock.lock();
				map.put(sessionId, users);
			} finally {
				lock.unlock();
			}
		}
	}

	public void removeUser(String sessionId) {
		if (!StringUtils.isEmpty(sessionId)) {
			try {
				lock.lock();
				map.remove(sessionId);
			} finally {
				lock.unlock();
			}
		}
	}

	public Users getUser(String sessionId) {
		if (!StringUtils.isEmpty(sessionId)) {
			Users users = null;
			try {
				lock.lock();
				users = map.get(sessionId);
			} finally {
				lock.unlock();
			}
			return users;
		}
		return null;
	}

	/**
	 * 用户是否存在
	 * 
	 * @param id
	 *            用户ID
	 * @return 存在返回true
	 */
	public boolean hasUser(String id) {
		boolean ret = false;
		if (!StringUtils.isEmpty(id)) {
			try {
				lock.lock();
				Iterator iterator = map.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry entry = (Map.Entry) iterator.next();
					Users users = (Users) entry.getValue();
					if (users.getUserName().equals(id)) {
						ret = true;
						break;
					}
				}
			} finally {
				lock.unlock();
			}
		}
		return ret;
	}

	/**
	 * 用户超时清理（用户登录后，未操作的时间间隔超过系统设定的最大时间）
	 */
	public void invalidateClear() {
		try {
			lock.lock();
			log.info("开始清理超时用户,当前在线总用户数为:" + map.size());
			// 遍历map清除失效数据
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Users users = (Users) entry.getValue();
				if (users.isInvalidate()) {
					log.info(entry.getKey() + ":(" + users.getUserName() + ":"
							+ users.getIp() + ")用户已经超时，被清除");
					iterator.remove();
					users = null;
				}
			}
		} finally {
			log.info("结束清理超时用户,当前在线总用户数为:" + map.size());
			lock.unlock();
		}
	}

	/**
	 * 
	 */
	public int getOnLineUserCount() {
		int count = 0;
		try {
			lock.lock();
			count = map.size();
		} finally {
			lock.unlock();
		}
		return count;
	}
}
