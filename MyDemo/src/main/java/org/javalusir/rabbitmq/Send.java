package org.javalusir.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * this demo is use to send message by rabbitMQ,to run this demo the RabbitMQ must be
 * installed.and maybe you need to install Erlang environment before.
 * @author lu
 *
 */
public class Send {

	public static void main(String[] args) throws IOException, TimeoutException{
		
		ConnectionFactory connectFactory = new ConnectionFactory();
		
		connectFactory.setHost("localhost");
		
		Connection connection = connectFactory.newConnection();
		
		Channel channel = connection.createChannel();
		
		boolean durable = true;
		channel.queueDeclare(Rev.QUEUE_NAME, durable, false, false, null);
		
		for(int i=0;i<10;i++){
			String message = "hello world!";
			message+=i;
			channel.basicPublish("", Rev.QUEUE_NAME, null, message.getBytes());
		}
		
		//System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}
