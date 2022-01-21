package gametheory2;

import java.util.ArrayList;

public abstract class Challenger implements Contestant { //the implements keyword is how you make use of an interface
	
	private String name;				//the name
	private int health;					//their health
	private ArrayList<Integer> moves;	//the moves they've used
	
	//the first three constants here establish the convention for numbering the moves that the contestants
	//make to play in the tournament against each other
	
	public Challenger(String newName) {
		health = TournWrapper.INIT_HEALTH;	//how to refer to a constant from another file
		name = newName;		
		moves = new ArrayList<Integer>();
	}
	
	//an implementation of most of the methods we promised to implement in Contestant...	
	public String getName() { return name; }
	public String toString() { return name + " has " + health + " units remaining."; }
	
	public int getHealth() { return health; }
	public void setHealth(int newHP) { health = newHP; }
	public void addHealth(int inc) { health += inc; }
	
	public ArrayList<Integer> getMoves() { return moves; }
	public void addMove(int newMove) { moves.add(newMove); }
	public void clearMoves() { moves.clear(); }
	
	//...except this one, which will differ depending on how you write it for each challenger you come up with
	public abstract int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves);
}
