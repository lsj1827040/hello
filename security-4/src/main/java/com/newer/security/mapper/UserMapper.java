package com.newer.security.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	@Insert("insert into users(username,password) values(#{username},#{password})")
	void insert(String username,String password);
	
	@Insert("insert into authorities(username,authority) values(#{username},#{authority})")
	void insert2(String username,String authority);
}
