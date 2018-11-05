package com.example.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

	@Autowired
	private HelloSender1 helloSender1;
	@Autowired
	private HelloSender1 helloSender2;
	@Autowired
	private UserSender userSender;
	
	@PostMapping("hello")
	public void hello(String s){
		System.out.println(s);
		helloSender1.send(s);
	}
	@PostMapping("user")
	public void sendUser(){
		User user = new User();
		user.setId(1);
		user.setName("小明");
		userSender.send(user);
	}
	@PostMapping("oneToMany")
	public void one2many(){
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hello1:"+i);
			helloSender2.send("hello2:"+i);
		}
	}
}
