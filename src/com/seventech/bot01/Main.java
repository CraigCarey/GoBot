package com.seventech.bot01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Main {
	
	static Robot robot;
	static Board goBoard;
	
	public static void main(String[] args) throws AWTException
	{
		// topLeftX, topLeftY, botRightX, botRightY, numSquares
		goBoard = new Board(1549, 290, 2300, 1040, 9);
		robot = new Robot();

		int[] coords = goBoard.getPointPixel('J',7);
		clickPoint(coords);
	}
	
	public static void clickPoint(int[] coords)
	{
		robot.mouseMove(coords[0], coords[1]);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(100);
	}
	
	public static void clickAllPoints()
	{
		for(int y = goBoard.numSquares - 1; y >= 0; y--)
		{
			for(int x = 0; x < goBoard.numSquares; x++)
			{
				int[] coords = goBoard.getPointPixel(x, y);
				clickPoint(coords);				
			}
		}		
	}
}