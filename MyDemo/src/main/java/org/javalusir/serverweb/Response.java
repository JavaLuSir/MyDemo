package org.javalusir.serverweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * simple http response
 * @author lu
 *
 */
public class Response {

	private static final int BUFFER_SIZE=1024;
	Request request;
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	OutputStream out;
	public Response(OutputStream out){
		this.out=out;
	}
	public OutputStream getOut() {
		return out;
	}
	public void setOut(OutputStream out) {
		this.out = out;
	}
	public void sendStaticResource() throws IOException{
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(HttpServer.WEB_ROOT,request.getUri());
			if(file.exists()){
				fis = new FileInputStream(file);
				int che = fis.read(bytes,0,BUFFER_SIZE);
				while(che!=-1){
					out.write(bytes, 0, che);
					che =fis.read(bytes,0,BUFFER_SIZE);
				}
			}else{
				String err="HTTP/1.1 404 File Not Found\r\n Content-Type:text/html\r\nContent-Length:23\r\n"+
						"\r\n"+
						"<h1>File Not Found</h1>";
				out.write(err.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				fis.close();
			}
		}
	}
}
