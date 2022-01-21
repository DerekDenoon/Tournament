package gametheory2;

import java.awt.Point;

public class gameMatrix {
	
	public static Point[][] matrix; //the payoff matrix
	
	//these constants represent the indices of the payoff matrix
	public static final int DEFEND = 0;
	public static final int ATTACK = 1;
	public static final int DESP_ATTACK = 2;
	
	//these constants determine the entries of the payoff matrix
	private static final int DEFEND_VAL = 0;
	private static final int DEF_ATT_VAL = -1;
	private static final int ATTACK_VAL = -2;
	private static final int DESP_VAL = -4;
	
	public gameMatrix() {
	}
	
	public static Point getResult(int first, int second) { 
		matrix = new Point[3][3];
		matrix[DEFEND][DEFEND] = new Point(DEFEND_VAL,DEFEND_VAL);
		matrix[DEFEND][ATTACK] = new Point(DEF_ATT_VAL,DEFEND_VAL);
		matrix[DEFEND][DESP_ATTACK] = new Point(DEFEND_VAL,DESP_VAL);
		matrix[ATTACK][DEFEND] = new Point(DEFEND_VAL,DEF_ATT_VAL);
		matrix[ATTACK][ATTACK] = new Point(ATTACK_VAL,ATTACK_VAL);
		matrix[ATTACK][DESP_ATTACK] = new Point(DESP_VAL,ATTACK_VAL);
		matrix[DESP_ATTACK][DEFEND] = new Point(DESP_VAL,DEFEND_VAL);
		matrix[DESP_ATTACK][ATTACK] = new Point(ATTACK_VAL,DESP_VAL);
		matrix[DESP_ATTACK][DESP_ATTACK] = new Point(DESP_VAL,DESP_VAL);
		return matrix[first][second]; 
	}
}
