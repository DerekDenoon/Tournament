package gametheory2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Tournament {

	private Contestant[] cons;			//the contestants
	private int[] wins; 				//keeps track of who beats who
	private int trials; 				//number of matches a pair of contestants will have to determine which wins

	private int[][] data; 				//wins for each match

	public Tournament(int numTrials) { //the constructor that initializes things
		ArrayList<Contestant> consList = new ArrayList<Contestant>();

		//come actual game time, each contestant will need to be initialized separately, not with a for loop
		//this is due to the fact that you're using multiple different kinds of contestants

		//put that initialization here
		
		//the players on this stage
		consList.add(new Contestant3("Contestant3 "));	//very generic names

		//and one more random contestant...
		consList.add(new TestContestant1("TestContestant1"));
		consList.add(new TestContestant2("TestContestant2"));
		consList.add(new TestContestant3("TestContestant3"));
		consList.add(new Derek2("Derek2"));
		consList.add(new Derek3("Derek3"));
		consList.add(new Derek4("Derek4"));


		cons = consList.toArray(new Contestant[0]); //a convenient way to transform an ArrayList into an array
		wins = new int[cons.length];				//how many wins each contestant got
		trials = numTrials;							//how many times contestants play against each other in runMatches
		data = new int[cons.length][cons.length];	//the win-loss matrix for the contestants
	}

	//since wins and cons are private variables, these are methods that provide access to their contents
	//these will be used in other classes, most notably TournWrapper
	public int[] getWins() { return wins; }					//get all vs. get a particular one
	public int getWins(int i) { return wins[i]; }
	
	public Contestant[] getCons() { return cons; }			//get all vs. get a particular one
	public Contestant getCons(int i) { return cons[i]; }

	public int[][] getData() { return data; }				//get all the win-loss data
	
	//returns the Contestant that wins the match, or null if the match ends tied
	public Contestant playMatch(Contestant first, Contestant second) {
		int rounds = 0;
		while (rounds < TournWrapper.MAX_ROUNDS){

//			System.out.println(first.toString());
//			System.out.println(second.toString());

			int firstStrat;
			int secondStrat;

			firstStrat = first.pickStrat(second.getName(),second.getHealth(),second.getMoves());
			secondStrat = second.pickStrat(first.getName(),second.getHealth(),first.getMoves());

			Point results = gameMatrix.getResult(firstStrat,secondStrat);
			first.addHealth(results.x);
			second.addHealth(results.y);

			rounds++;

			first.addMove(firstStrat);
			second.addMove(secondStrat);

			if(first.getHealth() < 0 || second.getHealth() < 0){
				if(first.getHealth() > second.getHealth()){
					return first;
				}else if (first.getHealth() < second.getHealth()){
					return second;
				}else if(first.getHealth() == second.getHealth()){
					return null;
				}
			}
		}




		//clear the moves for both contestants, and then...
		
		//run a match in a while loop that stops when at least one player's health has hit 0
		
		//that is, use a while loop to...
		//1) determine each player's strategy using their pickStrat
		//2) update their health using gameMatrix.getResult
		//3) update the round count
		//4) update each player's move history using addMove

		//when over TournWrapper.MAX_ROUNDS rounds are played, the match is a draw (return null as there was no winner)
		//if both players have the same, <=0 health, then the match is a draw (return null as there was no winner)
		//the winner, otherwise, has higher health, and is returned

		return null;
	}
	
	//runs trials number of matches between two players so that the dominant strategy asserts itself
	//make sure health gets reset before each new match
	//over the course of multiple runs (this is why some sports use best-of-7 series)
	//make sure that the wins and data array is updated appropriately
	public Contestant runMatches(int firstCon, int secondCon) {
		//you may or may not want to use these variables
		Contestant first = cons[firstCon];
		Contestant second = cons[secondCon];
		int firstWins = 0;
		int firstLoses = 0;
		int draws = 0;
		//conduct a match for at least _trials_ number of times
		//if tied, return the result of a fair coin flip between first and second
		for (int i = 0; i < trials; i++) {
			Contestant c = playMatch(first,second);
			if (!Objects.isNull(c) && c.equals(first)){
				firstWins++;
			}else if (!Objects.isNull(c) && c.equals(second)){
				firstLoses++;
			}else{
				draws++;
			}
			first.setHealth(TournWrapper.INIT_HEALTH);
			second.setHealth(TournWrapper.INIT_HEALTH);
//			if (playMatch(first,second).equals(first)){
//				firstWins++;
//			}else{
//				firstLoses++;
//			}
//			System.out.println(draws);
		}
// UPDATE DATA
		data[firstCon][secondCon] = firstWins;
		data[secondCon][firstCon] = firstLoses;

		if (firstWins == firstLoses) {
			double rand = Math.random();
			if (rand > 0.5){
				return first;
			}else{
				return second;
			}

		}
		if(firstWins > firstLoses){
			return first;
		}else{
			return second;
		}


		//before returning the winner, update the data[][] variable so that the number
		//of wins by each side is stored in that variable
		//return the winning side's contestant variable
	}
		
	//have contestants face each other in a round robin setting for a numTrials number of matches
	//update your wins variable here
	public void runTournament() {
//		playMatch(new Contestant1("con1"),new Contestant2("con2"));
		for (int i = 0; i < cons.length - 1; i++) {
			for (int j = i + 1; j < cons.length; j++) {
				Contestant c = runMatches(i,j);
				if (c.equals(getCons(i))){
					wins[i]++;
				}else if (c.equals(getCons(j))){
					wins[j]++;
				}

			}
		}


		//your code goes here

	}
	
	//some extra functions so that you can try to test your code out on contestants
	
	//this one displays the wins and losses for a particular contestant
	public void dataByContestant(int consIndex) {
		System.out.println("Data for " + cons[consIndex].getName() + ".");
		String verb = "";
		for (int i = 0; i < cons.length; i++) {
			if (i != consIndex) {
				if (data[i][consIndex] > data[consIndex][i]) { //I guess technically it's verb and preposition
					verb = " loses to ";
				} else {
					verb = " wins against ";
				}
				System.out.println(cons[consIndex].getName() + verb + cons[i].getName() + ", " + data[consIndex][i] + " to " + data[i][consIndex] + "!");
			}
		}
	}
	
	//outputs the data array in its entirety
	//a bunch of arcane formatting things lie ahead
	public void output() {
		String formatString = "%" + Integer.toString((int)(Math.log10(trials)) + 1) + "d";
		for (int i = 0; i < data.length; i++) {
			System.out.printf(String.format("%-15s ", cons[i].getName()));
			System.out.printf(String.format("[ " + formatString, data[i][0]));
			for (int j = 1; j < data[i].length; j++) {
				System.out.printf(String.format(", " + formatString, data[i][j]));
			}
			System.out.println("]");
		}
	}
}
