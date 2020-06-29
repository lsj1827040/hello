package com.newer.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newer.security.mapper.UserMapper;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	UserMapper usermapper;
	
	@Transactional
	@Override
	public void join(String username, String password) {
		//用户密码
		String pwd=new BCryptPasswordEncoder().encode(password);
		usermapper.insert(username, pwd);
	}

}
