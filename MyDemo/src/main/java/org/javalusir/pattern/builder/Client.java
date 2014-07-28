package org.javalusir.pattern.builder;

public class Client {

	public static void main(String[] args) {
		Builder b = new SubBuilder();
		Director d = new Director(b);
		Person p = d.construct();
		
		System.out.println(p.getHead());
		System.out.println(p.getBody());
		System.out.println(p.getFoot());
	}
}
