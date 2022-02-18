package gametheory2;

import java.util.ArrayList;

public class TestContestant1 extends Challenger{
    // always defends

    public TestContestant1(String newName) {
        super(newName);
    }

    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        return gameMatrix.DEFEND;
    }

}
