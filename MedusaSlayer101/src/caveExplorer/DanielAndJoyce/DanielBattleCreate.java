package caveExplorer.DanielAndJoyce;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class DanielBattleCreate {
	
	public static Scanner in = new Scanner(System.in);
	public static String[][] ships;
	public static int[][] field;
	public static int CLEAN = -1;
	public static int MISS = 0;
	public static int HIT = 1;
	public static int FIELDSIZE = 7;
	
	public static int CARRIER = 4;
	public static int BATTLESHIP = 3;
	public static int SUBMARINE = 2;
	public static int DESTROYER = 1;
	
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
		field = new int[FIELDSIZE][FIELDSIZE];
		ships = new String[FIELDSIZE][FIELDSIZE];
		
		backField(field);
		makeField(field);
		createStarterCoordinates(ships);
		placeCarrier(ships, carrierRow, carrierCol);
		placeBattleship(ships, battleRow, battleCol);
		placeSubmarine(ships, subRow, subCol);
		placeDestroyer(ships, destroyerRow, destroyerCol);
		System.out.println("heuulo");
		
	}
	
	public static void backField(int[][] field){
//		for(int r = 0 ; r < FIELDSIZE ; r++ )
//			for(int c = 0 ; c < field.length ; c++)
//				field[r][c] = CLEAN;
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				field[row][col] = CLEAN;
			}
		}
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
	
	public static void fireCannon(){
		System.out.println("Choose a Row in which you think a ship is located in:");
		int rowInput = in.nextInt();
		
		System.out.println("Choose a Column in which you think a ship is located in:");
		int colInput = in.nextInt();
		
		if(!(ships[rowInput][colInput].equals(""))){
			field[rowInput][colInput] = HIT;
		}
		if(ships[rowInput][colInput].equals("")){
			field[rowInput][colInput] = MISS;
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
			row = (int)(Math.random() * ships.length);
			col = (int)(Math.random() * (ships[0].length - 2));
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
			row = (int)(Math.random() * ships.length);
			col = (int)(Math.random() * (ships[0].length - 1));
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
			row = (int)(Math.random() * ships.length);
			col = (int)(Math.random() * (ships[0].length));
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
	public static void createStarterCoordinates(String[][] ships2){
		//helper method
		
		carrierRow = (int)(Math.random() * (ships2.length));
		carrierCol = (int)(Math.random() * (ships2[0].length - 3));
		
		battleRow = (int)(Math.random() * (ships2.length));
		battleCol = (int)(Math.random() * (ships2[0].length - 2));
		
		subRow = (int)(Math.random() * (ships2.length));
		subCol = (int)(Math.random() * (ships2[0].length - 1));
		
		destroyerRow = (int)(Math.random() * (ships2.length));
		destroyerCol = (int)(Math.random() * (ships2[0].length));
	}
}
