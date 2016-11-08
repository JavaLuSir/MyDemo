package org.javalusir.pattern.adapter;
/**
 * 
 * @author JavaLuSir
 *
 */
public class Dollar_RMB_Adapter implements ISpendRMB{

	private Dollar dollar;
	
	public Dollar_RMB_Adapter(Dollar dollar){
		this.dollar=dollar;
	}
	/**
	 * change dollar to rmb
	 */
	public void spend() {
		System.out.println(this.dollar.getDollar()*6);
	}
	
}
