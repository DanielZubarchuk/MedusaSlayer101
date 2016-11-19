/*
	WHOLE GAME:
		- can leave room and event will trigger every time player enters until player wins game in event room
		- 
*/
package caveExplorer.DanielAndJoyce;

import java.util.Scanner;

import caveExplorer.DanielAndJoyce.*;

public class JoyceBattleCreate {
	
	Scanner input = new Scanner(System.in);
	String[] ships = {"Destroyer", "Submarine", "Battleship", "Aircraft Carrier"};// 1, 2, 3, 4
	
	static int FIELDSIZE = 7;
	static int SHIPNUM = 4;
	static int CLEAN = -1;
	static int MISS = 0;
	static int HIT = 1;
	
	public JoyceBattleCreate(){
		
		int[][] pField = new int[FIELDSIZE][FIELDSIZE];
		int[][] pShips = new int[FIELDSIZE][FIELDSIZE];
		initializeField(pField);
		makeField(pField);
		
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
		System.out.println("You have 4 ships in your inventory. You have an Aircraft Carrier, a Battleship, a Submarine"
				+ " , and a Destroyer. They take up 4, 3, 2, and 1 places on the board, respectively. Let's place your "
				+ "ships!");
		for(int i = 0; i<SHIPNUM; i++){
			System.out.println("You have " + SHIPNUM + " left. This is your " + ships[SHIPNUM-1] + ". "
					+ "What row would you like your " + ships[SHIPNUM-1] + " to be placed?");
			String shipSpaces = "";
			for (int j = 0; j < ships[SHIPNUM-1].length(); j ++){
				shipSpaces += ships[SHIPNUM-1].charAt(0);
			}
			System.out.print(shipSpaces);
			int firstShipSpot = 
			//put on field
			SHIPNUM--;
		}	
	}
	public void createField(){
		

			
	}

}
