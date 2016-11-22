package caveExplorer.DanielAndJoyce;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class DanielBattleCreate {
	
	//initialize
	public static Scanner in = new Scanner(System.in);
	public static int FIELDSIZE = 7;
	public static int[][] field = new int[FIELDSIZE][FIELDSIZE];
	public static String[][] ships = new String[FIELDSIZE][FIELDSIZE];
	public static int CLEAN = -1;
	public static int MISS = 0;
	public static int HIT = 1;
	public static boolean cheatMode = false;
	
	//ships
	public static final int CARRIER = 4;
	public static final int BATTLESHIP = 3;
	public static final int SUBMARINE = 2;
	public static final int DESTROYER = 1;
	
	//winning conditions
	private static int CARRIERCOUNT = CARRIER;
	private static int BATTLESHIPCOUNT = BATTLESHIP;
	private static int SUBMARINECOUNT = SUBMARINE;
	private static int DESTROYERCOUNT = DESTROYER;
	
	//private static String starterCoordinates;
	public static Random rand = new Random();
	public static int carrierRow;
	public static int carrierCol;
	public static int battleRow;
	public static int battleCol;
	public static int subRow;
	public static int subCol;
	public static int destroyerRow;
	public static int destroyerCol;

	public DanielBattleCreate() {
		
	}
	
	public static void engageInBattle(){
		backField(field);
		printField(field);
		initializeShips(ships);
		System.out.println("Do you need hints?");
		String answer = in.nextLine();
		if(answer.equals("yes")){
			cheatMode = true;
		}
		createStarterCoordinates(ships);
		placeCarrier(ships, carrierRow, carrierCol);
		placeBattleship(ships, battleRow, battleCol);
		placeSubmarine(ships, subRow, subCol);
		placeDestroyer(ships, destroyerRow, destroyerCol);
		//printShips(ships);
	}
	
	public static void initializeShips(String[][] ships){
		for(int row = 0; row < ships.length; row++){
			for(int col = 0; col < ships[row].length; col++){
				ships[row][col] = " ";
			}
		}
	}
	
	public static void backField(int[][] field){
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				field[row][col] = CLEAN;
			}
		}
	}
	
	public static void printField(int[][] field){
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7");
        System.out.println();
        
        for(int row = 0 ; row < FIELDSIZE ; row++){
            System.out.print((row+1)+"");
            for(int col = 0 ; col < FIELDSIZE ; col++){
                if(field[row][col] == CLEAN){
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
	
	public static void printShips(String[][] ships){
		System.out.println("AI Field");
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7");
        System.out.println();
        
        for(int row = 0 ; row < FIELDSIZE ; row++){
            System.out.print((row+1)+"");
            for(int col = 0 ; col < FIELDSIZE ; col++){
            	System.out.print("\t"+ ships[row][col]);
            }
            System.out.println("\n");
        }
	} 
	
	public static void fireCannon(){
		System.out.println("Choose a Row in which you think a ship is located in:");
		int rowInput = in.nextInt() - 1;
		
		System.out.println("Choose a Column in which you think a ship is located in:");
		int colInput = in.nextInt() - 1;
		
		if(!(ships[rowInput][colInput].equals(" "))){
			field[rowInput][colInput] = HIT;
				if(ships[rowInput][colInput].equals("C")){
					CARRIERCOUNT--;
					if(CARRIERCOUNT == 0){
						System.out.println("You have destroyed the AircraftCarrier!");
					}
				}
				if(ships[rowInput][colInput].equals("B")){
					BATTLESHIPCOUNT--;
					if(BATTLESHIPCOUNT == 0){
						System.out.println("You have destroyed the Battleship!");
					}
				}
				if(ships[rowInput][colInput].equals("S")){
					SUBMARINECOUNT--;
					if(SUBMARINECOUNT == 0){
						System.out.println("You have destroyed the Submarine!");
					}
				}
				if(ships[rowInput][colInput].equals("D")){
					DESTROYERCOUNT--;
					if(DESTROYERCOUNT == 0){
						System.out.println("You have destroyed the Destroyer!");
					}
				}
			}
			if((CARRIERCOUNT + BATTLESHIPCOUNT + SUBMARINECOUNT + DESTROYERCOUNT) == 0){
				System.out.println("You have destroyed the Roman Navy!");
				JoyceBattleCreate.checkWin();
			}
		if(ships[rowInput][colInput].equals(" ")){
			field[rowInput][colInput] = MISS;
		}
		
		printField(field);
	}
	
	public static void placeCarrier(String[][] ships, int row , int col){
		if(cheatMode == true){
			System.out.println("Initial Carrier coord: " + (row+1) +"," + (col+1));
		}
		for(int i = 0; i < CARRIER; i++){
			ships[row][col + i] = "C";
		}
	}
	
	public static void placeBattleship(String[][] ships, int row, int col){
		if(cheatMode == true){
			System.out.println("Possible Initial BattleShip coord: " + (row+1) +"," + (col+1));
		}
		int[][] battleshipCoordinates = new int [3][2];
		int newRow = row;
		
		boolean startOver = true; 
		
		while(startOver) {
			
			for (int pos=0; pos < BATTLESHIP; pos++) {
				if (ships[newRow][col].equals(" ")) {
					battleshipCoordinates[pos][0] = newRow;
					battleshipCoordinates[pos][1] = col;
					newRow++;
					startOver = false;
				} else {
					newRow = (int)(Math.random() * (ships.length)- 2);
					col = (int)(Math.random() * (ships[0].length));
					startOver = true;
					break;
				}
			}
			
		}
		
		
		// Valid coordinates recorded in battleshipCoordinates
		for(int i = 0; i < battleshipCoordinates.length; i++){
			ships[battleshipCoordinates[i][0]][battleshipCoordinates[i][1]] = "B";
		}
	}
	
	
	public static void placeSubmarine(String[][] ships, int row, int col){
		if(cheatMode == true){
			System.out.println("Possible Initial Submarine coord: " + (row+1) +"," + (col+1));
		}
		int[][] submarineCoordinates = new int [2][2];
		int newRow = row;
		
		boolean startOver = true;
		
		while(startOver) {
			
			for (int pos=0; pos < SUBMARINE; pos++) {
				if (ships[newRow][col].equals(" ")) {
					submarineCoordinates[pos][0] = newRow;
					submarineCoordinates[pos][1] = col;
					newRow++;
					startOver = false;
				} else {
					newRow = (int)(Math.random() * (ships.length)- 1);
					col = (int)(Math.random() * (ships[0].length));
					startOver = true;
					break;
				}
			}
			
		}
		
		
		// Valid coordinates recorded in submarineCoordinates
		for(int i = 0; i < submarineCoordinates.length; i++){
			ships[submarineCoordinates[i][0]][submarineCoordinates[i][1]] = "S";
		}
	}
	
	public static void placeDestroyer(String[][] ships, int row, int col){
		if(cheatMode == true){
			System.out.println("Possible Initial Destroyer coord: " + (row+1) +"," + (col+1));
		}
		int[][] destroyerCoordinates = new int [1][2];
		int newRow = row;
		
		boolean startOver = true;
		
		while(startOver) {
			
			for (int pos=0; pos < DESTROYER; pos++) {
				if (ships[newRow][col].equals(" ")) {
					destroyerCoordinates[pos][0] = newRow;
					destroyerCoordinates[pos][1] = col;
					newRow++;
					startOver = false;
				} else {
					newRow = (int)(Math.random() * (ships.length));
					col = (int)(Math.random() * (ships[0].length));
					startOver = true;
					break;
				}
			}
			
		}
		
		
		// Valid coordinates recorded in destroyerCoordinates
		for(int i = 0; i < destroyerCoordinates.length; i++){
			ships[destroyerCoordinates[i][0]][destroyerCoordinates[i][1]] = "D";
		}
		
	}
	public static void createStarterCoordinates(String[][] ships2){
		//helper method
		
		carrierRow = (int)(Math.random() * (ships2.length));
		carrierCol = (int)(Math.random() * (ships2[0].length - 3));
		
		battleRow = (int)(Math.random() * (ships2.length- 2));
		battleCol = (int)(Math.random() * (ships2[0].length));
		
		subRow = (int)(Math.random() * (ships2.length- 1));
		subCol = (int)(Math.random() * (ships2[0].length));
		
		destroyerRow = (int)(Math.random() * (ships2.length));
		destroyerCol = (int)(Math.random() * (ships2[0].length));
	}
}
