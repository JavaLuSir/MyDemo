package org.javalusir.pattern.bridge;

public class Client {

	public static void main(String[] args) {
		Shape shape = new Circle(3,6,9,new DrawRectangle());
		shape.draw();
	}
}
