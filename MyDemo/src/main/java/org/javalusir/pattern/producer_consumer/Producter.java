package org.javalusir.pattern.producer_consumer;
/**
 * Producter
 * @author JavaLuSir
 *
 */
public class Producter implements Runnable{

	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProductStorage.getInstance().puduct();
		}
	}

}
