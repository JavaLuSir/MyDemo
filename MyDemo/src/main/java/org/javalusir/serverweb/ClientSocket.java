package org.javalusir.serverweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * a serversocket client demo
 * @author lu
 *
 */
public class ClientSocket {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		/*Socket socket = new Socket("127.0.0.1",8080);
		
		OutputStream os = socket.getOutputStream();
		
		boolean autoflush = true;
		
		PrintWriter out = new PrintWriter(os,autoflush);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
*/		
/*		int port = 9000;   
		InetAddress addr = InetAddress.getByName("127.0.0.1");
		Socket socket = new Socket(addr,port);
		OutputStream os = socket.getOutputStream();
		PrintWriter out  = new PrintWriter(os, true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.println("GET /index.html HTTP/1.1");
		out.println("Host:"+addr.getHostAddress()+":"+port);
		out.println("Connection:Close");
		out.println();
		//read response 
		boolean loop = true;
		StringBuffer sbf =new StringBuffer();
		while(loop){
			if(in.ready()){
				int i=0;
				while(i!=-1){
					i = in.read();
					sbf.append((char)i);
				}
				loop = false;
			}
			Thread.sleep(50);
		}
		System.out.println(sbf);
		socket.close();*/
		int port=9000;
		InetAddress addr = InetAddress.getByName("localhost");
		Socket socket = new Socket(addr,port);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		pw.println("GET /index.html HTTP/1.1");
		pw.println("HOST:"+addr.getHostName()+":"+port);
		pw.println("Connection:close");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		StringBuilder sbb = new StringBuilder();
		boolean isfinish = false;
		while(!isfinish){
			if(bfr.ready()){
				int i = 0;
				while(i!=-1){
					i=bfr.read();
					sbb.append((char)i);
				}
				isfinish = true;
			}
			Thread.sleep(50);
		}
		System.out.println(sbb);
		socket.close();
	}
}
