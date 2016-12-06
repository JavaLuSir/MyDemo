package org.javalusir.serverweb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * simple http server
 * @author lu
 *
 */
public class HttpServer {

	public static final String WEB_ROOT=System.getenv("USERPROFILE")+File.separator+"webroot";
	
	public static final String SHUTDOWN_URL="/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public void await() throws IOException{
		System.out.println(WEB_ROOT);
		int port = 9000;
		ServerSocket serversocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		while(!shutdown){
			Socket socket = null;
			InputStream input = null;
			OutputStream out = null;
		
			socket=serversocket.accept();
			input=socket.getInputStream();
			out=socket.getOutputStream();
			Request request = new Request(input);
			request.prase();
			
			Response response = new Response(out);
			response.setRequest(request);
			response.sendStaticResource();
			socket.close();
			shutdown = request.getUri().equals(SHUTDOWN_URL);
		
		}
	}
	
	public static void main(String[] args) throws IOException {
		HttpServer server = new HttpServer();
		server.await();
		
	}
}
