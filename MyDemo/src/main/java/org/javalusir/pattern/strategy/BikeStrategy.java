package org.javalusir.pattern.strategy;
/**
 * bike strategy demo implements IStrategy
 * @author JavaLuSir
 *
 */
public class BikeStrategy implements IStrategy{

	@Override
	public void goSomeWhere() {
		System.out.println("bike go there");
	}

}
