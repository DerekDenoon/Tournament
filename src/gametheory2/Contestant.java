package gametheory2;

import java.util.ArrayList;

//an interface is like a contract, a promise that classes that implement this interface will write code for each method listed here
//all but the last one are implemented in the Challenger abstract class
//we need this interface so that the Tournament can consider each contestant as being one of a common class
public interface Contestant {
	
	public String getName();				//gets the name
	public String toString();				//how to display a contestant in a println
	
	public int getHealth();					//gets the health
	public void setHealth(int newHP);		//sets the health
	public void addHealth(int inc);			//adds the health
	
	public ArrayList<Integer> getMoves();	//gets the move
	public void addMove(int newMove);		//adds a move to the move list
	public void clearMoves();				//clears the move list
	
	public int pickStrat(String name, int health, ArrayList<Integer> oppMoves); //however you code your strategy...
}
