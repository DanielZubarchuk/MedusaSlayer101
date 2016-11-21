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

	public DanielBattleCreate() {
		field = new int[FIELDSIZE][FIELDSIZE];
		ships = new String[FIELDSIZE][FIELDSIZE];
		
		int carrierRow = (int)(1 + Math.random() * ships.length);
		int carrierCol = (int)(1 + Math.random() * (ships[0].length - 3));
		
		int battleRow = (int)(1 + Math.random() * ships.length);
		int battleCol = (int)(1 + Math.random() * (ships[0].length - 2));
		
		int subRow = (int)(1 + Math.random() * ships.length);
		int subCol = (int)(1 + Math.random() * (ships[0].length - 1));
		
		int destroyerRow = (int)(1 + Math.random() * ships.length);
		int destroyerCol = (int)(1 + Math.random() * ships[0].length);
		
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
        System.out.println("\t1 \t2 \t3 \t4 \t5");
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
                System.out.println();
            }
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
		for(int i = 0; i < BATTLESHIP; i++){
			ships[row + i][col] = "B";
		}
	}
	
	public static void placeSubmarine(String[][] ships, int row, int col){
		for(int i = 0; i < SUBMARINE; i++){
			ships[row + i][col] = "S";
		}
	}
	
	public static void placeDestroyer(String[][] ships, int row, int col){
		ships[row][col] = "D";  
		
	}
	
	private static void createStarterCoordinates(String[][] ships2){
		//helper methods
		
		int carrierRow = (int)(1 + Math.random() * ships2.length);
		int carrierCol = (int)(1 + Math.random() * (ships2[0].length - 3));
		
		int battleRow = (int)(1 + Math.random() * ships2.length);
		int battleCol = (int)(1 + Math.random() * (ships2[0].length - 2));
		
		int subRow = (int)(1 + Math.random() * ships2.length);
		int subCol = (int)(1 + Math.random() * (ships2[0].length - 1));
		
		int destroyerRow = (int)(1 + Math.random() * ships2.length);
		int destroyerCol = (int)(1 + Math.random() * ships2[0].length);
	}

	
	

//	public static void placeCarrier(int[][] ships){
//		String[] carrier = new String[4];
//		String carrierStarter = (String) createStarterCoordinates(ships);
//		carrier[0] = carrierStarter;
//		for(int i = 1; i < carrier.length; i++){
//			carrier[i] = carrierStarter;
//		}
//	}
//	
//	public static void placeBattleship(int[][] ships){
//		String[] battleship = new String[3];
//		String battleshipStarter = (String) createStarterCoordinates(ships);
//		battleship[0] = battleshipStarter;
//		for(int i = 1; i < battleship.length; i++){
//			
//		}
//	}
//	
//	public static void placeSubmarine(int[][] ships){
//		String[] submarine = new String[2];
//		String submarineStarter = (String) createStarterCoordinates(ships);
//		submarine[0] = submarineStarter;
//		
//		for(int i = 1; i < submarine.length; i++){
//			
//		}
//	}
//	
//	public static void placeDestroyer(int[][] ships){
//		String[] destroyer = new String[1];
//		destroyer[1] = (String) createStarterCoordinates(ships);
//	}
//	
//	private static Object createStarterCoordinates(int[][] ships){
//		//helper method
//		int row = (int)(1 + Math.random() * ships.length);
//		int col = (int)(1 + Math.random() * ships[0].length);
//		return starterCoordinates = "("+row+", "+col+")";
//	}
}
