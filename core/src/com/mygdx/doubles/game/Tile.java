package com.mygdx.doubles.game;

public class Tile {
	
	int value;

    public Tile() {
    	
    	this(0);
    }

    public Tile(int num) {
    	
    	value = num;
    }

    public boolean isEmpty() {
    
    	return value == 0;
    }
    
    public int toInteger() {
        return value;
    }

}
