package gametheory2;

import java.util.ArrayList;

public class ContestantDD extends Challenger{

    public ContestantDD(String newName) {
        super(newName);
    }

    private int time = 0;


    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        if (getHealth() > (TournWrapper.INIT_HEALTH /2)){
            time = 0;
        }
        if (time < 5){

        }else {
            double rand = Math.random();
            int strategy;
            strategy = strategySelect(oppName, oppHealth, oppMoves);
            switch (strategy) {
                case 0 -> {
                    if (rand < 1.0 / 3.0) {
                        return gameMatrix.DEFEND;
                    } else if (rand < 2.0 / 3.0) {
                        return gameMatrix.ATTACK;
                    }
                    return gameMatrix.DESP_ATTACK;
                }
                case 1 -> {
                    return gameMatrix.DEFEND;
                }
                case 2 -> {
                    return gameMatrix.ATTACK;
                }
                case 3 -> {
                    return gameMatrix.DESP_ATTACK;
                }
                case 4 -> {
                    System.out.println("4");
                }
                case 5 -> {
                    System.out.println("5");
                }
                case 6 -> {
                    System.out.println("6");
                }
                case 7 -> {
                    System.out.println("7");
                }
                case 8 -> {
                    System.out.println("8");
                }
                default -> throw new IllegalStateException("Unexpected value: " + strategy);
            }
        }
        return 0;
    }

    public int strategySelect(String oppName, int oppHealth, ArrayList<Integer> oppMoves){

        return 0;
    }




}
