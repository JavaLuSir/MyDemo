package org.javalusir.serverweb;

import java.io.InputStream;
/**
 * simple http request
 * @author lu
 *
 */
public class Request {
	
	private InputStream input;
	private String uri;
	
	public Request(InputStream input) {
		this.input = input;
	}

	public void prase(){
		StringBuffer request = new StringBuffer(2048);
		int i = 0;
		byte[] buffer = new byte[2048];
		try{
			i=input.read(buffer);
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int j=0;j<i;j++){
			request.append((char)buffer[j]);
		}
		System.out.println(request.toString());
		uri = parseUri(request.toString());
	}
	
	public String parseUri(String requestString){
		int index1 ,index2;
		index1 = requestString.indexOf(" ");
		if(index1!=-1){
			index2=requestString.indexOf(" ",index1+1);
			if(index2>index1){
				return requestString.substring(index1+1, index2);
			}
		}
		return null;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
}
