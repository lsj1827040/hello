package com.newer.security.service;

public interface AccountService {
	
	/**
	 * 注册用户
	 * @param username
	 * @param password
	 */
	void join(String username,String password);

}
