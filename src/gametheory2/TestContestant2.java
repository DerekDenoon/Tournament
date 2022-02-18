package gametheory2;

import java.util.ArrayList;

public class TestContestant2 extends Challenger{
    public TestContestant2(String newName) {
        super(newName);
    }

    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {

        if (oppMoves.isEmpty()) {
            return gameMatrix.ATTACK;
        }
        return (oppMoves.get(oppMoves.size()-1) + 1) % 3;
    }
}
