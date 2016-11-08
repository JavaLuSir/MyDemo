package org.javalusir.rabbitmq;


public class RPCInvoke {

	public static void main(String[] args){
		try {
			RPCClient fibonacciRpc = new RPCClient();

			System.out.println(" [x] Requesting fib(30)");   
			String response = fibonacciRpc.call("3");
			System.out.println(" [.] Got '" + response + "'");

			fibonacciRpc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
