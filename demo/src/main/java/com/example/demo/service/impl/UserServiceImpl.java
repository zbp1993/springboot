package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> getUserInfo() {
		 return userMapper.findUserInfo();
	}

	@Override
	public void insert(User user) {
		userMapper.addUserInfo(user);
		
	}

	@Override
	public User getUser(User user) {
		User u = userMapper.getUser(user);
		return u;
	}

}
