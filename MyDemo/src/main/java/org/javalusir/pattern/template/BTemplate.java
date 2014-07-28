package org.javalusir.pattern.template;

/**
 * extends Template and Override doSomething method
 * @author JavaLuSir
 *
 */
public class BTemplate extends Template{

	/**
	 * template's implemented
	 */
	@Override
	protected void doSomething() {
		System.out.println("This b Template");
	}

}
