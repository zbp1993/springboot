package com.example.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(User user){
		System.out.println("send:"+user.getName());
		rabbitTemplate.convertAndSend("userQueue", user);
	}
}
