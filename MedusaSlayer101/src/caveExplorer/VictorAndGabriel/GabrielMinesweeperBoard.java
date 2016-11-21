package caveExplorer.VictorAndGabriel;

import java.util.Random;

public class GabrielMinesweeperBoard {
    static Random random = new Random();
    
    public GabrielMinesweeperBoard (){
       
    }
    
    public static void createBoard(int row, int col){
         randomlyPlaceMines(row, col);
         placeNumbers(row, col);
    }
    
    public static void randomlyPlaceMines(int row, int col){
    	//method places mines randomly on board.
    	//mines marked with -1
    	int minesPlaced = 0;
            while(minesPlaced <= 4){
                int randomRow = (int) (Math.random()*8);
                int randomCol = (int) (Math.random()*8);
                EventVictorAndGabriel.board[randomRow][randomCol] =-1;
                minesPlaced = minesPlaced + 1;
                if(randomRow == row){
                	if(randomCol == col){
                		if(minesPlaced > 0){
                			minesPlaced = minesPlaced - 1;
                		}
                	}
                }
                
            }
    }
    
    public static void placeNumbers(int firstRow, int firstCol){
        for(int row = 0; row < EventVictorAndGabriel.board.length; row++){
        	for(int col = 0; col < EventVictorAndGabriel.board[row].length; col ++){
        		int nearbyMines = 0;
        		if(EventVictorAndGabriel.board[row][col] != -1){
        			if(row != firstRow){
        				if(col != firstCol){
        					EventVictorAndGabriel.board[row][col] = nearbyMines(row,col);
        				}
        			}
        		}
        	}
        	
        }
    }

	public static int nearbyMines(int row, int col) {
		int mines = 0;
		
	    mines += mineAt(row - 1, col - 1);  // NW
	    mines += mineAt(row - 1, col);      // N
	    mines += mineAt(row - 1, col + 1);  // NE
	    mines += mineAt(row, col - 1);      // W
	    mines += mineAt(row, col + 1);      // E
	    mines += mineAt(row + 1, col - 1);  // SW
	    mines += mineAt(row + 1, col);      // S
	    mines += mineAt(row + 1, col + 1);  // SE
		return mines;
	}

	private static int mineAt(int row, int col) {
		if(row >= 0 && row < EventVictorAndGabriel.board.length && col >= 0 && col < EventVictorAndGabriel.board[row].length && 
				EventVictorAndGabriel.board[row][col] == -1){
			return 1;
		}
		return 0;
	}
   
}

