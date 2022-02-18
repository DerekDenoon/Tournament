package gametheory2;

import java.util.ArrayList;

public class Derek2 extends Challenger{

    public Derek2(String newName) {
        super(newName);
    }

    int time = 0;

    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        if (getHealth() >= (TournWrapper.INIT_HEALTH/2)){
            time++;
            return (oppMoves.size() + time) % 3;
        }
        return (oppMoves.size() +  2 * time) % 3;
    }
}
