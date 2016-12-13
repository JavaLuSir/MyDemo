package org.javalusir.serverweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * simple http response
 * @author lu
 *
 */
public class Response implements HttpServletResponse{

	private static final int BUFFER_SIZE=1024;
	Request request;
	OutputStream out;
	PrintWriter writer;
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}

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
		File file = new File(HttpServer.WEB_ROOT,request.getUri());
		if(file.exists()){
			fis = new FileInputStream(file);
			int readint = fis.read(bytes, 0, BUFFER_SIZE);
			while(readint!=-1){
				out.write(bytes, 0, readint);
				readint = fis.read(bytes, 0, BUFFER_SIZE);
			}
		}else{
			String err="HTTP/1.1 404 File Not Found\r\n Content-Type:text/html\r\nContent-Length:23\r\n"+
					"\r\n"+
					"<h1>File Not Found</h1>";
			out.write(err.getBytes());
		}
		/*
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
	*/
		}
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	public PrintWriter getWriter() throws IOException {
		writer = new PrintWriter(out,true);
		return writer;
	}
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}
	public void addCookie(Cookie arg0) {
		// TODO Auto-generated method stub
		
	}
	public void addDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}
	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	public void addIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	public boolean containsHeader(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public String encodeRedirectURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String encodeRedirectUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String encodeURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String encodeUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<String> getHeaders(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void sendError(int arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	public void sendError(int arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}
	public void sendRedirect(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	public void setDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
}
