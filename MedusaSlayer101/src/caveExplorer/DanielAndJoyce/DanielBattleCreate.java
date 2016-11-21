package caveExplorer.DanielAndJoyce;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class DanielBattleCreate {
	
	public static Scanner in = new Scanner(System.in);
	static String[][] ships;
	static int[][] field;
	static int CLEAN = -1;
	static int MISS = 0;
	static int HIT = 1;
	static int FIELDSIZE = 7;
	
	static int CARRIER = 4;
	static int BATTLESHIP = 3;
	static int SUBMARINE = 2;
	static int DESTROYER = 1;
	
	//private static String starterCoordinates;
	public static Random rand = new Random();
	private static int carrierRow;
	private static int carrierCol;
	private static int battleRow;
	private static int battleCol;
	private static int subRow;
	private static int subCol;
	private static int destroyerRow;
	private static int destroyerCol;

	public DanielBattleCreate() {
		
	}
	
	public static void engageInBattle(){
		field = new int[FIELDSIZE][FIELDSIZE];
		ships = new String[FIELDSIZE][FIELDSIZE];
		
		backField(field);
		makeField(field);
		createStarterCoordinates(ships);
		placeCarrier(ships, carrierRow, carrierCol);
		placeBattleship(ships, battleRow, battleCol);
		placeSubmarine(ships, subRow, subCol);
		placeDestroyer(ships, destroyerRow, destroyerCol);
	}
	public static void backField(int[][] field){
		for(int r = 0 ; r < FIELDSIZE ; r++ )
			for(int c = 0 ; c < FIELDSIZE ; c++)
				field[r][c] = CLEAN;
	}
	
	public static void makeField(int[][] field){
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
	
	public static void fireCannon(int col, int row){
		System.out.println("Choose a Row in which you think a ship is located in:");
		int rowInput = in.nextInt();
		
		System.out.println("Choose a Column in which you think a ship is located in:");
		int colInput = in.nextInt();
		
		if(!(ships[rowInput][colInput].equals(""))){
			field[rowInput][colInput] = HIT;
		}
		
	}
	
	public static void placeCarrier(String[][] ships, int row , int col){
		for(int i = 0; i < CARRIER; i++){
			ships[row][col + i] = "C";
		}
	}
	
	public static void placeBattleship(String[][] ships, int row, int col){
		int newRow = row;
		boolean action = true;
		while (action){
			row = (int)(1 + Math.random() * ships.length);
			col = (int)(1 + Math.random() * (ships[0].length - 2));
			ships[row][col] = "B";
			while (!ships[newRow][col].equals("C")){
				for(int i = 0; i < BATTLESHIP;i++) {
					newRow = row + i;
					ships[row + i][col] = "B";
				}
		    action = false;
			}
		}	
	}
	
	
	public static void placeSubmarine(String[][] ships, int row, int col){
		int newRow = row;
		boolean action = true;
		while (action){
			row = (int)(1 + Math.random() * ships.length);
			col = (int)(1 + Math.random() * (ships[0].length - 1));
			ships[row][col] = "S";
			while (!ships[newRow][col].equals("C") || !ships[newRow][col].equals("B")){
				for(int i = 0; i < SUBMARINE;i++) {
					newRow = row + i;
					ships[row + i][col] = "S";
				}
			    action = false;
			}
		}
	}
	
	public static void placeDestroyer(String[][] ships, int row, int col){
		int newRow = row;
		boolean action = true;
		while (action){
			row = (int)(1 + Math.random() * ships.length);
			col = (int)(1 + Math.random() * (ships[0].length));
			ships[row][col] = "D";
			while (!ships[newRow][col].equals("C") || !ships[newRow][col].equals("B") || !ships[newRow][col].equals("S")){
				for(int i = 0; i < SUBMARINE;i++) {
					newRow = row + i;
					ships[row + i][col] = "D";
				}
			    action = false;
			}
		}
		
	}
	private static void createStarterCoordinates(String[][] ships2){
		//helper method
		
		carrierRow = (int)(Math.random() * (ships2.length-1));
		carrierCol = (int)(Math.random() * (ships2[0].length - 4));
		
		battleRow = (int)(Math.random() * (ships2.length-1));
		battleCol = (int)(Math.random() * (ships2[0].length - 3));
		
		subRow = (int)(Math.random() * (ships2.length-1));
		subCol = (int)(Math.random() * (ships2[0].length - 2));
		
		destroyerRow = (int)(Math.random() * (ships2.length-1));
		destroyerCol = (int)(Math.random() * (ships2[0].length-1));
	}
	/*private static void createStarterCoordinates(String[][] ships2){
		//helper method
		
		carrierRow = (int)(1 + Math.random() * (ships2.length-1));
		carrierCol = (int)(1 + Math.random() * (ships2[0].length - 4));
		
		battleRow = (int)(1 + Math.random() * (ships2.length-1));
		battleCol = (int)(1 + Math.random() * (ships2[0].length - 3));
		
		subRow = (int)(1 + Math.random() * (ships2.length-1));
		subCol = (int)(1 + Math.random() * (ships2[0].length - 2));
		
		destroyerRow = (int)(1 + Math.random() * (ships2.length-1));
		destroyerCol = (int)(1 + Math.random() * (ships2[0].length-1));
	}*/
}
