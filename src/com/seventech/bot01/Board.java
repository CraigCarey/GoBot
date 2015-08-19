package com.seventech.bot01;

public class Board {
	
	int tlX = 0;	// x coordinate of top left corner of board (A9)
	int tlY = 0;
	int brX = 0;
	int brY = 0;	// y coordinate of bottom right corner of board (J1)
	
	int numSquares = 0;	
	
	// dimensions in pixels
	int boardWidth = 0;
	int boardHeight = 0;
	int squareWidth = 0;
	int squareHeight = 0;
		
	public Board(int tlX, int tlY, int brX, int brY, int numSquares)
	{	
		this.tlX = tlX;
		this.tlY = tlY;
		this.brX = brX;
		this.brY = brY;
		
		this.numSquares = numSquares;
		
		boardWidth = brX - tlX;
		boardHeight = brY - tlY;
		
		squareWidth = boardWidth / (numSquares - 1);
		squareHeight = boardHeight / (numSquares - 1);
				
	}
	
	// returns the pixel locations of a point given as a board coordinate
	public int[] getPointPixel(int x, int y)
	{	
		int[] coords = {(tlX + x * squareWidth), (tlY + y * squareHeight)};		
		return coords;
	}
	
	// overloaded to take human readable coords
	public int[] getPointPixel(char x, int y)
	{
		int xInt = xCoordTranslater(x);
		
		y = numSquares - y;
		
		int[] coords = {(tlX + xInt * squareWidth), (tlY + y * squareHeight)};		
		return coords;
	}
		
	public int xCoordTranslater(char x)
	{
		x = Character.toUpperCase(x);
		
		if(x == 'J') x = 'I';
				
		return (int) (x - 'A');
	}

}
