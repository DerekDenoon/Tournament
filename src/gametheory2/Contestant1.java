package gametheory2;

import java.util.ArrayList;

public class Contestant1 extends Challenger {

	public Contestant1(String newName) {
		super(newName);
	}
	
	@Override //here to state you're overriding an abstract method in the superclass Challenger
	public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
		// Available Variables

		// OWN
		// health
		// name
		// moves

		// oppName
		// oppHealth
		// oppMoves
		
		if (oppMoves.isEmpty()) {
			return gameMatrix.ATTACK;
		}
		return (oppMoves.get(oppMoves.size()-1) + 1) % 3;
	}
}
