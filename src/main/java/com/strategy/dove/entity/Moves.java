package com.strategy.dove.entity;

public class Moves {
	
	char move;

	public Moves() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moves(char move) {
		super();
		this.move = move;
	}

	public char getMove() {
		return move;
	}

	public void setMove(char move) {
		this.move = move;
	}

	@Override
	public String toString() {
		return "Moves [move=" + move + "]";
	}
	
	

}
