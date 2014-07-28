package org.javalusir.pattern.prototype;
/**
 * this class dynamic Key prototype
 * @author JavaLuSir
 *
 */
public class Client {

	public static void main(String[] args) {
		Key k = new Key();
		k.setKeyOwner("zhangsan");
		Key k2 = k.clone();
		System.out.println(k2.getKeyOwner()); 
		System.out.println(k2==k); 
		
	}
}
