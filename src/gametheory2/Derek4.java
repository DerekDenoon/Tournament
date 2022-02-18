package gametheory2;
// hi

import java.util.ArrayList;

public class Derek4 extends Challenger{
    public Derek4(String newName) {
        super(newName);
    }

    private int time = 0;

    @Override
    public int pickStrat(String oppName, int oppHealth, ArrayList<Integer> oppMoves) {
        if (time == 0){
            time++;
            return gameMatrix.DEFEND;
        }
        if (time == 1){
            time++;
            if (winLast(oppMoves).equals(0)){
                // if win
                System.out.println(getMoves().get(getMoves().size() - 1));
                return getMoves().get(getMoves().size() - 1);
            }else if (winLast(oppMoves).equals(1)){
                // if lose
                System.out.println((oppMoves.get(oppMoves.size() - 1) + 2) % 3);
                return (oppMoves.get(oppMoves.size() - 1) + 2) % 3;

            }else if(winLast(oppMoves).equals(2)){
                // if tie
                System.out.println(getMoves().get(getMoves().size() -1));
                return getMoves().get(getMoves().size() -1);
            }

        }
        if (time > 1){
            if (winLast(oppMoves).equals(0)){
                // if win
                System.out.println(oppMoves.get(oppMoves.size() -1));
                return oppMoves.get(oppMoves.size() -1);
            }else if (winLast(oppMoves).equals(1)){
                // if lose
                System.out.println((oppMoves.get(oppMoves.size() - 1) + 2) % 3);
                return (oppMoves.get(oppMoves.size() - 1) + 2) % 3;

            }else if(winLast(oppMoves).equals(2)){
                // if tie
                System.out.println(getMoves().get(getMoves().size() -1));
                return getMoves().get(getMoves().size() -1);
            }

        }


        return gameMatrix.DEFEND;
    }

    public Integer winLast(ArrayList<Integer> oppMoves){
        // returns 0 if win
        // returns 1 if lose
        // returns 3 if tie
       int oppMove = oppMoves.get(oppMoves.size() - 1);
       int move = getMoves().get(getMoves().size() - 1);

        if (oppMove == move){
            return 2;
        }

       if (move == 0){
           if (oppMove == 1){
               return 1;
           }else{
               return 0;
           }

       }else if(move == 1){
           if (oppMove == 0){
               return 0;
           }else{
               return 1;
           }

       }else if(move == 2){
           if (oppMove == 0){
               return 1;
           }else{
               return 0;
           }

       }

       return null;
    }
}
