/*
	WHOLE GAME:
		- can leave room and event will trigger every time player enters until player wins game in event room
		- 
		
	MINE:
		- put in a exit trigger
		- need a cheat code!!!!
		- PSHIPS ARRAY ARE INT BUT THEY BECOME STRING AT ONE PONT??
		
		
		TEST CODE:
	String[] o = {"Hey", "no"};
	String kek = "";
	
	for (int i =0; i < o[0].length(); i++){
		kek += o[0].charAt(0);
	}System.out.print(kek);
*/
package caveExplorer.DanielAndJoyce;

import java.util.Scanner;

import caveExplorer.DanielAndJoyce.*;

public class JoyceBattleCreate {
	
	static Scanner input = new Scanner(System.in);
	static String[] ships = {"Destroyer", "Submarine", "Battleship", "Aircraft Carrier"};// 1, 2, 3, 4
	
	static int[][] pField;
	static int[][] pShips;
	static int FIELD_SIZE = 7;
	static int SHIP_NUM = 4;
	static int SHIP_NUM2 = 4;
	static boolean repeat = false;
	static boolean spotCanHappen = false;
	static boolean choicesCanHappen = false;
	static boolean win = true;
	static boolean aiWin = false;
	
	static int RIGHT = 1; static int LEFT = -1; static int TOP = -1; static int BOTTOM = 1;
	static String[] shipDirection = {"Top", "Right", "Bottom", "Left"};
	static int OCCUPIED = -2; static int CLEAN = -1; static int MISS = 0; static int HIT = 1;

	public JoyceBattleCreate(){
		
	}
	
	public static void initializeField(int[][] field){
		for(int r = 0 ; r < FIELD_SIZE ; r++ ){
			for(int c = 0 ; c < FIELD_SIZE ; c++){
				field[r][c] = CLEAN;				
			}
		}
	}
	
	public static void makeField(){  
		String top = "";
		for (int i = 1; i < FIELD_SIZE + 1; i++){
			top += "\t" + i;
		}
        System.out.print(top);
        System.out.println();
        
        for(int row = 0 ; row < FIELD_SIZE ; row++){
            System.out.print((row+1)+"");
            for(int col = 0 ; col < FIELD_SIZE ; col++){
            	if(pField[row][col] == OCCUPIED){
            		System.out.print("\t" + (char)(pShips[row][col]));
            	}
            	else{
            		if(pField[row][col] == CLEAN){
            			System.out.print("\t"+"~");
            		}
                else{
                	if(pField[row][col] == MISS){
                		System.out.print("\t"+"*");
                	}else{
                		if(pField[row][col] == HIT){
                			System.out.print("\t"+"X");
                		}
                    
                	}
                
                }   
            } 
        }
            System.out.println("\n");
	}
	}
	
	public static void userField() {
		pField = new int[FIELD_SIZE][FIELD_SIZE];
		pShips = new int[FIELD_SIZE][FIELD_SIZE];
		initializeField(pField);
		initializeField(pShips);
		makeField();
		
		System.out.println("You have 4 ships in your inventory. You have an Aircraft Carrier, a Battleship, a Submarine"
				+ " , and a Destroyer.\nThey take up 4, 3, 2, and 1 places on the board, respectively. Let's place your "
				+ "ships!");
		for(int i = 0; i < SHIP_NUM2; i++){
			String currentShip = ships[SHIP_NUM-1];
			String shipSpaces = "";
			int rowBeginShip = 0;
			int colBeginShip = 0;
			 
			do{
				if (repeat == true) System.out.println("You've alreayd placed a ship there! Choose somewhere else.");
				System.out.println("You have " + SHIP_NUM + " ships left. This is your " + currentShip + ". "
					+ "What ROW would you like the beginning of your " + currentShip + " to be placed?");
				for (int j = 0; j < SHIP_NUM; j ++){
					shipSpaces += currentShip.charAt(0);
				}
				System.out.print(shipSpaces);
				shipSpaces = "";
				
				rowBeginShip = input.nextInt() -1;
				while(rowBeginShip < 0 || rowBeginShip > FIELD_SIZE-1){
					System.out.println("Choose a row between 1 and 7.");
					rowBeginShip = input.nextInt() -1;
				}
				System.out.println("What COLUMN would you like the beginning of your " + currentShip + " to be placed?");
				colBeginShip = input.nextInt() -1;
				while(colBeginShip < 0 || colBeginShip > FIELD_SIZE-1){
					System.out.println("Choose a col between 1 and 7.");
					colBeginShip = input.nextInt() -1;
				}
				
				checkSpot(rowBeginShip, colBeginShip);

			}while (spotCanHappen == false);
			spotCanHappen = false;
			repeat = false;
			
			int[] orientationOptions = orientShip(rowBeginShip, colBeginShip, SHIP_NUM);
			String pChoice = "";
			
			do{
				String choices = "";
				
				for(int k = 0; k < orientationOptions.length; k++){
					if (orientationOptions[k] != 0) {
						choices += shipDirection[k] + ", ";
					}
				}
				
				System.out.println("You can orient your " + currentShip + " to the " + choices + "how do you want it?");
				pChoice = input.next();
				checkCanHappen(rowBeginShip, colBeginShip, pChoice, SHIP_NUM);
			}while(choicesCanHappen == false);
			choicesCanHappen = false;
			
			System.out.println("Your " + currentShip + " is oriented to the " + pChoice + ".");
			changeOrientation(SHIP_NUM, currentShip, pChoice, rowBeginShip, colBeginShip);
			makeField();
			SHIP_NUM--;
		}	
	}
	private static void checkSpot(int row, int col) {
		if (pShips[row][col] == CLEAN) spotCanHappen = true;
		else repeat = true;
	} 

	private static void checkCanHappen(int row, int col, String c, int shipLength) {
		boolean pos = true;
			if(c.equals("Top")){
				for (int i = 0; i < shipLength-1; i++){
					if (pShips[row + TOP][col] != CLEAN){
						pos = false;
						break;
					}
				}
			}
			if(c.equals("Bottom")){
				for (int i = 0; i < shipLength-1; i++){
					if (pShips[row + BOTTOM][col] != CLEAN){
						pos = false;
						break;
					}
				}
			}
			if(c.equals("Left")){
				for (int i = 0; i < shipLength-1; i++){
					if (pShips[row][col + LEFT] != CLEAN){
						pos = false;
						break;
					}
				}
			}
			if(c.equals("Right")){
				for (int i = 0; i < shipLength-1; i++){
					if (pShips[row][col + RIGHT] != CLEAN){
						pos = false;
						break;
					}
				}
			}
			if (pos == true) choicesCanHappen = true;
		}

	private static void changeOrientation(int s, String ship, String choice, int row, int col) {
		char shipLetter = ship.charAt(0);
		pShips[row][col] = shipLetter;
		pField[row][col] = OCCUPIED;
		for (int i = 0; i < s-1; i++){
			if (choice.equals("Top")){
				pShips[row + TOP][col] = shipLetter;
				pField[row + TOP][col] = OCCUPIED;
				row = row + TOP;
			}
			if (choice.equals("Right")){
				pShips[row][col + RIGHT] = shipLetter;
				pField[row][col + RIGHT] = OCCUPIED;
				col = col + RIGHT;
			}
			if (choice.equals("Bottom")){
				pShips[row + BOTTOM][col] = shipLetter;
				pField[row + BOTTOM][col] = OCCUPIED;
				row = row + BOTTOM;
			}
			if (choice.equals("Left")){
				pShips[row][col + LEFT] = shipLetter;
				pField[row][col + LEFT] = OCCUPIED;
				col = col + LEFT;
			}
			
		}
	}

	private static int[] orientShip(int row, int col, int cShip) {
		int[] poss = {TOP, RIGHT, BOTTOM, LEFT};
		if (row-cShip < 0) poss[0] = 0;
		if (col > (FIELD_SIZE - cShip)) poss[1] = 0;
		if (row > (FIELD_SIZE - cShip)) poss[2] = 0;
		if (col-cShip < 0) poss[3] = 0;
		return poss;
	}
	
	public static void aiHitPlayer(){
		int row = (int) (Math.random()*FIELD_SIZE);
		int col = (int) (Math.random()*FIELD_SIZE);
		
		String hitOrMiss = "";
		if (pShips[row][col] == CLEAN || pShips[row][col] == HIT) {
			pField[row][col] = MISS;
			hitOrMiss = "missed.";
		}			
		else {
			pField[row][col] = HIT;
			hitOrMiss = " hit a target.";
		}
		makeField();
		System.out.println("The Roman Navy has chosen to fire at (" + (row+1) + ", " + (col+1) + "). It has " + hitOrMiss + " Your turn!" );
		//checkWin();
	}
	
	public static void checkWin(){
		//boolean win = false;
		for (int i = 0; i < pShips.length; i++){
			for (int j = 0; j < pShips[0].length; j++){
				if (pShips[i][j] != CLEAN){
					if (pField[i][j] != HIT){
						win = false;
						//return win;
					}
				}
			}
		}
		if (win == true){
			EventDanielAndJoyce.gameWork = false;
			aiWin = true;
			System.out.println("You've been defeated by the Roman Navy." + "\n");
		}
		win = true;
		
		//return win;
	}
}
