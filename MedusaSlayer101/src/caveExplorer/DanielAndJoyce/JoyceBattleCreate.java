/*
	WHOLE GAME:
		- can leave room and event will trigger every time player enters until player wins game in event room
		- 
		
	MINE:
		- put in a exit trigger
		- need a cheat code!!!!
		
		
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
	
	/*ShipJAndD pAircraft = new ShipJAndD("Aircraft Carrier", 4); 
	ShipJAndD pBattleship = new ShipJAndD("Battleship", 3);
	ShipJAndD pSubmarine = new ShipJAndD("Submarine", 2);
	ShipJAndD pDestroyer = new ShipJAndD("Destroyer", 1);*/
	
	Scanner input = new Scanner(System.in);
	String[] ships = {"Destroyer", "Submarine", "Battleship", "Aircraft Carrier"};// 1, 2, 3, 4
	//ships = {pAircraft, pBattleship, pSubmarine, pDestroyer};
	
	static int[][] pField;
	static int[][] pShips;
	static int FIELD_SIZE = 7;
	static int SHIP_NUM = 4;
	boolean spotCanHappen = false;
	boolean choicesCanHappen = false;
	
	static int RIGHT = 1; static int LEFT = -1; static int TOP = -1; static int BOTTOM = 1;
	static String[] shipDirection = {"Top", "Right", "Bottom", "Left"};
	static int OCCUPIED = -2; static int CLEAN = -1; static int MISS = 0; static int HIT = 1;

	public JoyceBattleCreate(){
		
		pField = new int[FIELD_SIZE][FIELD_SIZE];
		pShips = new int[FIELD_SIZE][FIELD_SIZE];
		initializeField(pField);
		makeField(pField);
		
	}
	
	public static void initializeField(int[][] field){
		for(int r = 0 ; r < FIELD_SIZE ; r++ ){
			for(int c = 0 ; c < FIELD_SIZE ; c++){
				field[r][c] = CLEAN;				
			}
		}
	}
	
	public static void makeField(int[][] field){  
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();
        
        for(int row = 0 ; row < FIELD_SIZE ; row++){
            System.out.print((row+1)+"");
            for(int col = 0 ; col < FIELD_SIZE ; col++){
            	if(field[row][col] == OCCUPIED){
            		System.out.println("\t" + pShips[row][col]);
            	}
            	else if(field[row][col] == CLEAN){
                    System.out.print("\t"+"~");
                }else{
                	if(field[row][col] == MISS){
                		System.out.print("\t"+"*");
                	}else{
                		if(field[row][col] == HIT){
                			System.out.print("\t"+"X");
                		}
                    
                	}
                
                }   
            } 
            System.out.println("\n");
        }
	} 
	
	public void userField() {
		System.out.println("You have 4 ships in your inventory. You have an Aircraft Carrier, a Battleship, a Submarine"
				+ " , and a Destroyer. They take up 4, 3, 2, and 1 places on the board, respectively. Let's place your "
				+ "ships!");
		for(int i = 0; i<SHIP_NUM; i++){
			String currentShip = ships[SHIP_NUM-1];
			String shipSpaces = "";
			int rowBeginShip = 0;
			int colBeginShip = 0;
			
			while (spotCanHappen == false){
				System.out.println("You have " + SHIP_NUM + " left. This is your " + currentShip + ". "
					+ "What ROW would you like the begining of your " + currentShip + " to be placed?");
				for (int j = 0; j < currentShip.length(); j ++){
					shipSpaces += currentShip.charAt(0);
				}
				System.out.print(shipSpaces);
				
				rowBeginShip = input.nextInt();
				System.out.println("What COLUMN would you like the beginning of your " + currentShip + " to be placed?");
				colBeginShip = input.nextInt();
				
				checkCanHappen(rowBeginShip, colBeginShip, 1);
			}
			int[] orientationOptions = orientShip(rowBeginShip, colBeginShip, currentShip);
			String pChoice = "";
			while(choicesCanHappen == false){
				String choices = "";
				for (int k = 0; k < orientationOptions.length; i++){
					
					if (orientationOptions[k] != (Integer) null) choices += shipDirection[orientationOptions[k]] + "or ";
				}
				System.out.println("You can orient your " + currentShip + " to the " + choices + ". How do you want it?");
				pChoice = input.nextLine();
				checkCanHappen(rowBeginShip, colBeginShip, 2, pChoice);
			}
			changeOrientation(currentShip, pChoice, rowBeginShip, colBeginShip);
			
			//put on field
			SHIP_NUM--;
		}	
	}
	private void checkCanHappen(int row, int col, int type, String c) {
		if (type == 1){
			if (pShips[row][col] != OCCUPIED){ 
				spotCanHappen = true;
			}
		}else{
			if(c.equals("Top") || c.equals("Bottom")){
				
			}else{
				for (int i = )
			}
		}
	}

	private void changeOrientation(String s, String choice, int row, int col) {
		char shipLetter = s.charAt(0);
		pShips[row][col] = shipLetter;
		for (int i = 0; i < s.length()-1; i++){
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

	private int[] orientShip(int row, int col, String cShip) {
		int[] poss = {TOP, RIGHT, BOTTOM, LEFT};
		if (row-1 < cShip.length()) poss[0] = (Integer) null;
		if (col > (FIELD_SIZE - cShip.length())) poss[1] = (Integer) null;
		if (row > (FIELD_SIZE - cShip.length())) poss[2] = (Integer) null;
		if (col-1 < cShip.length()) poss[3] = (Integer) null;
		return poss;
	}

	public void createField(){
		

			
	}

}
