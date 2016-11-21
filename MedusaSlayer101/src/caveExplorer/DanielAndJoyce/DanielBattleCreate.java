package caveExplorer.DanielAndJoyce;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class DanielBattleCreate {
	
	public static Scanner in = new Scanner(System.in);
	static String[][] userSide;
	static int CLEAN = -1;
	static int MISS = 0;
	static int HIT = 1;
	static int FIELDSIZE = 7;
	private static String starterCoordinates;

	public DanielBattleCreate() {
		int[][] field = new int[FIELDSIZE][FIELDSIZE];
		int[][] ships = new int[FIELDSIZE][FIELDSIZE];
		
		
		//createStarterCoordinates(ships);
		placeCarrier(ships);
		placeBattleship(ships);
		placeSubmarine(ships);
		makeField(field);
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
	
	public static void fireCannon(int[] shoot){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Row:");
		shoot[0] = input.nextInt();
		shoot[0]--;
		
		System.out.print("Column:");
		shoot[1] = input.nextInt();
		shoot[1]--;
		
	}
	
	
	public static void placeCarrier(int[][] ships){
		String[] carrier = new String[4];
		
		String carrierStarter = (String) createStarterCoordinates(ships);
		
		carrier[0] = carrierStarter;
		
		for(int i = 1; i < carrier.length; i++){
			
		}
		
	}
	
	public static void placeBattleship(int[][] ships){
		String[] battleship = new String[3];
		
		String battleshipStarter = (String) createStarterCoordinates(ships);
		
		battleship[0] = battleshipStarter;
		
		for(int i = 1; i < battleship.length; i++){
			
		}
		
		
		
	}
	
	public static void placeSubmarine(int[][] ships){
		String[] submarine = new String[2];
		
		String submarineStarter = (String) createStarterCoordinates(ships);
		
		submarine[0] = submarineStarter;
		
		for(int i = 1; i < submarine.length; i++){
			
		}
		
		
		
	}
	
	public static void placeDestroyer(int[][] ships){
		String[] destroyer = new String[1];
		
		destroyer[1] = (String) createStarterCoordinates(ships);
		
		
	}
	
	
	
	private static Object createStarterCoordinates(int[][] ships){
		//helper method
		
		int row = (int)(1 + Math.random() * ships.length);
		int col = (int)(1 + Math.random() * ships[0].length);
		
		return starterCoordinates = "("+row+", "+col+")";
	}
}
