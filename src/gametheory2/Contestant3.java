package gametheory2;

import java.util.ArrayList;

public class Contestant3 extends Challenger {

	public Contestant3(String newName) {
		super(newName);
	}
	
	int time = 0;
	
	@Override //here to state you're overriding an abstract method in the superclass Challenger
	public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> moves) {
		if (oppHealth + getHealth() >= TournWrapper.INIT_HEALTH) time++;
		return (moves.size() +  2 * time) % 3;

	}

}
