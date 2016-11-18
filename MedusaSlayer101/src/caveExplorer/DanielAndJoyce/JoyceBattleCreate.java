package caveExplorer.DanielAndJoyce;

import java.util.Scanner;

import caveExplorer.DanielAndJoyce.*;

public class JoyceBattleCreate {
	
	Scanner ships = new Scanner(System.in);
	static int FIELDSIZE = 7;
	static int SHIPNUM = 4;
	static int CLEAN = -1;
	static int MISS = 0;
	static int HIT = 1;
	
	public JoyceBattleCreate(){
		
		int[][] pField = new int[FIELDSIZE][FIELDSIZE];
		int[][] pShips = new int[FIELDSIZE][FIELDSIZE];
		makeField(pField);
		initializeField(pField);
	}
	
	public static void initializeField(int[][] field){
		for(int r = 0 ; r < FIELDSIZE ; r++ ){
			for(int c = 0 ; c < FIELDSIZE ; c++){
				field[r][c] = CLEAN;				
			}
		}
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
            } 
            System.out.println("\n");
        }
	} 
	
	public void userField() {
		for(int i = 0; i<SHIPNUM; i++){
			System.out.println("You have " + SHIPNUM + " left. Where would you like your next ship to be placed?");
			//put on field
			SHIPNUM--;
		}	
	}
	public void createField(){
		

			
	}

}
