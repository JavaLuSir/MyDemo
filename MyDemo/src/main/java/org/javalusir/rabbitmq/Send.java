package org.javalusir.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	public static void main(String[] args) throws IOException, TimeoutException{
		ConnectionFactory connectFactory = new ConnectionFactory();
		connectFactory.setHost("localhost");
		Connection connection = connectFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(Rev.QUEUE_NAME, false, false, false, null);
		String message = "hello world!......";
		channel.basicPublish("", Rev.QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}
