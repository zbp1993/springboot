package com.example.demo.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {

	final static String queueName = "hell0";
	
	@Bean
	public Queue helloQueue(){
		return new Queue("hello");
	}
	
	@Bean
	public Queue userQueue(){
		return new Queue("user");
	}
	
	// 以下是验证topic Exchange的队列
	@Bean
	public Queue queueMessage(){
		return new Queue("topic.message");
	}
	
	@Bean
	public Queue queueMessages(){
		return new Queue("topic.messages");
	}
	//以上是验证topic Exchange的队列
	@Bean
	public Queue AMessage(){
		return new Queue("fanout.A");
	}
	
	@Bean
	public Queue BMessage(){
		return new Queue("fanout.B");
	}
	
	@Bean
	public Queue CMessage(){
		return new Queue("fanout.C");
	}
	//以上是验证Fanout Exchange 的队列
	@Bean
	TopicExchange exchange(){
		return new TopicExchange("exchange");
	}
	
	@Bean
	FanoutExchange fanoutExchange(){
		return new FanoutExchange("fanoutExchange");
	}
	
	/**
	 * 将队列topic.message与exchange 绑定， binding_key为topic.message,就是完全匹配
	 * 
	 */
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	/**
	 * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
	 */
	@Bean
	Binding bingdingExchangeMessages(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.#");
	}
	
	@Bean
	Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(BMessage).to(fanoutExchange);
	}
	
	@Bean
	Binding bindingExchangc(Queue CMessage,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(CMessage).to(fanoutExchange);
	}
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
