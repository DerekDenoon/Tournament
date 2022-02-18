package gametheory2;

import java.util.ArrayList;

public class TestContestant3 extends Challenger{
    public TestContestant3(String newName) {
        super(newName);
    }

    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        double yay = Math.random();
        if (yay < 1.0/3.0) {
            return gameMatrix.DEFEND;
        } else if (yay < 2.0/3.0) {
            return gameMatrix.ATTACK;
        }
        return gameMatrix.DESP_ATTACK;
    }
}
