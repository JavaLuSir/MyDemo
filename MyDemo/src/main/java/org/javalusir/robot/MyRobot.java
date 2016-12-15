package org.javalusir.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
/**
 * a robot demo it can auto do something
 * @author lu
 *
 */
public class MyRobot {

	public static void main(String[] args) throws AWTException, InterruptedException{
		Robot robot = new Robot();
		robot.mouseMove(710, 50);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
