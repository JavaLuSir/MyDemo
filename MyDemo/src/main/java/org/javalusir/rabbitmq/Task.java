package org.javalusir.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Task {

	public static void main(String[] args) throws IOException, TimeoutException{
		
		ConnectionFactory connectFactory = new ConnectionFactory();
		
		connectFactory.setHost("localhost");
		
		Connection connection = connectFactory.newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare(Work.EXCHANGE_NAME, "fanout");
		
		for(int i=0;i<10;i++){
			String message = "test--";
			message+=i;
			channel.basicPublish(Work.EXCHANGE_NAME,"", null, message.getBytes());
		}
		
		//System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}
