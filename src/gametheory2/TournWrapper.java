package gametheory2;

public class TournWrapper {

	private final static int NUM_TRIALS = 100; 	//how many times challengers play each other to determine the winner between a pair of challengers
	private final static int NUM_TOURN = 1; 	//number of tournaments
	public final static int MAX_ROUNDS = 100;		//number of rounds in a match
	public final static int INIT_HEALTH = 20; 	//this one sets the initial health for the game members
	
	public static void main(String[] args) {
		Tournament t = new Tournament(NUM_TRIALS);
		for (int tourn = 0; tourn < NUM_TOURN; tourn++) {
			t.runTournament();
			String result = "";
			System.out.println("The field has " + t.getCons().length + " players!");
			for (int i = 0; i < t.getCons().length; i++) {  //print out all records
				result = t.getCons(i).getName() + " won against " + t.getWins(i) + " player";
				if (t.getWins(i) == 1) { //the way English makes plurals is awesome
					result += ".";
				} else {
					result += "s.";
				}
				System.out.println(result);
			}
			for (int i = 0; i < t.getCons().length; i++) {  //print out all records
				System.out.println();
				t.dataByContestant(i);
			}
		}
		t.output();
	}
}
