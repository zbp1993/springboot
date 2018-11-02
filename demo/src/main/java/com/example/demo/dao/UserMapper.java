package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	public List<User> findUserInfo();
	public int addUserInfo(User user);
	public int delUserInfo(int id);
	public User getUser(User user);
}
