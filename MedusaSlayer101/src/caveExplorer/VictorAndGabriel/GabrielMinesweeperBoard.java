package caveExplorer.VictorAndGabriel;

import java.util.Random;

public class GabrielMinesweeperBoard {
    static Random random = new Random();
    
    public GabrielMinesweeperBoard (){
       
    }
    
    public static void createBoard(int row, int col){
         randomlyPlaceMines(row, col);
        // placeNumbers(row, col);
    }
    
    public static void randomlyPlaceMines(int row, int col){
    	//method places mines randomly on board.
    	//mines marked with -1
    	/**int minesPlaced = 0;
            while(minesPlaced < 10){
                int randomRow = (int) (Math.random()*8);
                int randomCol = (int) (Math.random()*8);
                EventVictorAndGabriel.board[randomRow][randomCol] =-1;
                if(randomRow == row && randomCol == col){
                	minesPlaced--;
            	}
                else{
                	minesPlaced++;
                }
            }
         **/
    	EventVictorAndGabriel.board[3][6]=-1;
    }
    
    public static void placeNumbers(int firstRow, int firstCol){
        for(int row = 0; row < EventVictorAndGabriel.board.length; row++){
        	for(int col = 0; col < EventVictorAndGabriel.board[row].length; col ++){
        		int nearbyMines = 0;
        		if(EventVictorAndGabriel.board[row][col] != -1 && row != firstRow && col != firstCol){ //checks through all cells
        			if(row -1 >= 0 && EventVictorAndGabriel.board[row-1][col] == -1){
        				nearbyMines++;
        			}
        			if(row +1 <= EventVictorAndGabriel.board.length-1 && EventVictorAndGabriel.board[row +1][col] ==-1){
        				nearbyMines++;
        			}
        			if(col-1 >= 0 && EventVictorAndGabriel.board[row][col-1] == -1){
        				nearbyMines++;
        			}
        			if(col+1 <= EventVictorAndGabriel.board[row].length-1 && EventVictorAndGabriel.board[row][col+1] ==-1){
        				nearbyMines++;
        			}
        			if(row -1 >= 0 && col-1 >= 0 && EventVictorAndGabriel.board[row-1][col-1] == -1){
        				nearbyMines++;
        			}
        			if(row -1 >= 0 && col+1 <= EventVictorAndGabriel.board[row].length-1 && EventVictorAndGabriel.board[row -1][col+1] ==-1){
        				nearbyMines++;
        			}
        			if(row +1 <= EventVictorAndGabriel.board.length-1 && col-1 >= 0 &&  EventVictorAndGabriel.board[row+1][col-1] == -1){
        				nearbyMines++;
        			}
        			if(row +1 <= EventVictorAndGabriel.board.length-1 && col+1 <= EventVictorAndGabriel.board[row].length-1 && EventVictorAndGabriel.board[row +1][col+1] ==-1){
        				nearbyMines++;
        			}
        		}
        		EventVictorAndGabriel.board[row][col] = nearbyMines;
        	}
        	
        }
    }
   
}

