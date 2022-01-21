package gametheory2;

import java.util.ArrayList;

public class Contestant2 extends Challenger {

	public Contestant2(String newName) {
		super(newName);
	}
	
	@Override //here to state you're overriding an abstract method in the superclass Challenger
	public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> moves) {
		double yay = Math.random();
		if (yay < 1.0/3.0) {
			return gameMatrix.DEFEND;
		} else if (yay < 2.0/3.0) {
			return gameMatrix.ATTACK;
		}
		return gameMatrix.DESP_ATTACK;
	}
}
