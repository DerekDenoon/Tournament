package gametheory2;
// v1.1

import java.util.ArrayList;

public class Derek3 extends Challenger{

    private int x = 0;

    public Derek3(String newName) {
        super(newName);
    }

    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        if (x > 8){
            x = 0;
        }
        double rand;
        double range;
        double inc;
        double v1;
        double v2;
        double v3;
        double val = function(x);
        double b1 = function(x-1);
        double b2 = function(x+1);

        if (b1 > b2){
           range = b1 - b2;
           inc = range/3;
           v1 = b2 + (inc);
           v2 = b2 + (2 * inc);
           v3 = b1;
        }else{
            range = b2 - b1;
            inc = range/3;
            v1 = b1 + (inc);
            v2 = b1 + (2 * inc);
            v3 = b2;
        }

        x++;
        rand = ((Math.random() * v3) + v1);
        if (val < v1){
            return gameMatrix.ATTACK;
        }else if (val > v1 && val < v2){
            return gameMatrix.DEFEND;
        }else{
            return gameMatrix.DESP_ATTACK;
        }


    }

    private double function(double x){
        return (x-1) * (x+2) * (x+3) * (x-4) * (x-15) * (x-50) * (x-20) * (x-30);
    }

}
