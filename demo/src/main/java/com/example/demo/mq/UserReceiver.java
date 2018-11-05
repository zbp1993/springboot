package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {
	
	@RabbitHandler
	public void process(User user){
		System.out.println("receiver:"+user.getName());
	}

}
