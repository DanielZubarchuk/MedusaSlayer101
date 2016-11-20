package caveExplorer.VictorAndGabriel;

import java.util.Random;

public class GabrielMinesweeperBoard {
    Random random = new Random();
    
    public GabrielMinesweeperBoard (){
       
    }
    
    public void createBoard(int row, int col){
         randomlyPlaceMines(row, col);
         placeNumbers();
    }
    
    public void randomlyPlaceMines(int row, int col){
    	//method places mines randomly on board.
    	//mines marked with -1
    	int minesPlaced = 0;
            while(minesPlaced < 10){
                int randomRow = random.nextInt(8) + 1;
                int randomCol = random.nextInt(8) + 1;
                EventVictorAndGabriel.board[randomRow][randomCol] =-1;
                if(randomRow == row && randomCol == col){
                	minesPlaced--;
            	}
                else{
                	minesPlaced++;
                }
            }
    }
    
    public void placeNumbers(){
        for(int row=1 ; row < 9 ; row++){
            for(int col=1 ; col < 9 ; col++){
                for(int i=-1 ; i<=1 ; i++){
                	for(int j=-1 ; j<=1 ; j++){
                		if(EventVictorAndGabriel.board[row][col] != -1){
                			if(EventVictorAndGabriel.board[row+i][col+j] == -1){
                				EventVictorAndGabriel.board[row][col]++;
                            }
                        }
                    }
                }        
            }
        }    
    }
   
}

