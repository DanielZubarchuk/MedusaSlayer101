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

	public DanielBattleCreate() {
		int[][] field = new int[FIELDSIZE][FIELDSIZE];
		int[][] ships = new int[FIELDSIZE][FIELDSIZE];
		
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
		
		System.out.print("Row: ");
		
		
		System.out.print("Column: ");
		
		
	}
	
	
	public static void createShips(int[][] ships){
		
	}
}
