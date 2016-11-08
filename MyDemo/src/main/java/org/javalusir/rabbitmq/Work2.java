package org.javalusir.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Work2 {


	public static final String QUEUE_NAME= "hello_work";
	public static final String EXCHANGE_NAME= "my_exchange_direct";
	
	public static void main(String[] args) throws IOException, TimeoutException{
		
		ConnectionFactory factory = new ConnectionFactory();
		
		factory.setHost("localhost");
	    
		Connection connection = factory.newConnection();
	   
	    Channel channel = connection.createChannel();
	    
	    channel.exchangeDeclare(Work2.EXCHANGE_NAME, "direct");
	    
	    String randomQueName = channel.queueDeclare().getQueue();
	    
	    channel.queueBind(randomQueName,Work2.EXCHANGE_NAME, "group2");
	    
	    //channel.queueDeclare(QUEUE_NAME, true, false, false, null);
	  
	    System.out.println(" group [*] Waiting for messages. To exit press CTRL+C");
	    
	    Consumer consumer = new DefaultConsumer(channel) {
	        @Override
	        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	            throws IOException {
	          String message = new String(body, "UTF-8");
	          
	          System.out.println(" [x] Received '" + message + "'"+Thread.currentThread().getName());
	        }
	      };
	    
	      channel.basicConsume(randomQueName, true, consumer);
	}

}
