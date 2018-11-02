package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController 
@RequestMapping("/user")  
public class UserController {  
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String turnJsp(){
		System.out.println("跳转测试");
		return "login/login";
	}
	@RequestMapping("/getUserInfo")
    public List<User> getUserInfo() {
		System.out.println("进来");
		List<User> user = userService.getUserInfo();
        System.out.println(user.toString());
        return user;
    }
	
	@RequestMapping("/addUserInfo")
    public String addUserInfo(User user) {
//		User user = new User();
//		user.setId(10);
//		user.setName("cwh");
		User userH = userService.getUser(user);
		if(userH != null && userH.getId()>0){
			return "该用户已存在";
		}
		userService.insert(user);
        return "success:"+user.toString();
    }
}
