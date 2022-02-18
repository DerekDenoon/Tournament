package gametheory2;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ContestantXTR extends Challenger {

    // Strategy Profiles ( known strategies counter using a similarity check. )
    ArrayList<ArrayList<Integer>> strats = new ArrayList<>();
    int numberOfStrats;
    ArrayList<Double> similarity = new ArrayList<>();

    public ContestantXTR(String newName) {
        super(newName);
        numberOfStrats = 100;
        // initialize strategies
        for (int i = 0; i < numberOfStrats; i++) {
            strats.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < numberOfStrats; i++) {
            similarity.add(0.0);
        }
        IntStream.range(0, 100).forEach(i -> strats.get(0).add(gameMatrix.DEFEND));
        IntStream.range(0, 100).forEach(i -> strats.get(1).add(gameMatrix.ATTACK));
        IntStream.range(0, 100).forEach(i -> strats.get(2).add(gameMatrix.DESP_ATTACK));
        for (int i = 0; i < 100; i++) {
            strats.get(3).add((gameMatrix.DEFEND + i) % 3);
            strats.get(4).add((gameMatrix.ATTACK + i) % 3);
            strats.get(5).add((gameMatrix.DESP_ATTACK + i) % 3);
        }

    }


    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        double yay = Math.random();
        System.out.println("strategy similar");
        System.out.println(strategySelect(oppMoves));
        if (yay < 1.0/3.0) {
            return gameMatrix.DEFEND;
        } else if (yay < 2.0/3.0) {
            return gameMatrix.ATTACK;
        }

        return gameMatrix.DESP_ATTACK;

    }

    public double similarity(ArrayList<Integer> oppMoves,ArrayList<Integer> compare){
        // outputs how similar the opponents strategy is to "compare"
        double similar = 0;
        int loopTimes = 0;
        for (int i = 0; i < oppMoves.size() && i < compare.size(); i++) {
            if (compare.get(i).equals(oppMoves.get(i))){
                similar++;
            }
            loopTimes++;
        }
        similar = similar/loopTimes;
//        System.out.println(similar);
        return similar;
    }

    public int strategySelect(ArrayList<Integer> oppMoves){
        // generate comparisons
        // create array of similarities
        // pick highest or random if less than some double (50%?)
        // 0: Random Strategy
        similarity.clear();
        for (int i = 0; i < oppMoves.size(); i++) {
            if ((getMoves().get(getMoves().size() - 1) + 1) % 3 == oppMoves.get(i)) {
                System.out.println("hi");
            }

        }

        for (int i = 0; i < 5; i++) {
            similarity.set(i,similarity(oppMoves,strats.get(i)));
        }
        System.out.println(similarity.toString());

        return 0;
    }

}
