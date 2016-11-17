package caveExplorer.DanielAndJoyce;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class DanielBattleCreate {
	
	public static Scanner in = new Scanner(System.in);
	static String[][] userSide;

	public DanielBattleCreate() {
		int[][] field = new int[5][5];
	
		
		
	}
	
	public static void backField(int[][] field){
		for(int r = 0 ; r < 5 ; r++ )
			for(int c = 0 ; c < 5 ; c++)
				field[r][c] = -1;
	}
	
	public static void makeField(int[][] field){
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();
        
        for(int row = 0 ; row < 5 ; row++){
            System.out.print((row+1)+"");
            for(int col = 0 ; col < 5 ; col++){
                if(field[row][col] == -1){
                    System.out.print("\t"+"~");
                }else{
                	if(field[row][col] == 0){
                		System.out.print("\t"+"*");
                	}else{
                		if(field[row][col] == 1){
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

}
