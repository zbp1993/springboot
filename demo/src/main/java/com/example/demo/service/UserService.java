package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	 public List<User> getUserInfo();
	    
	 public void insert(User user);

	public User getUser(User user);


}
