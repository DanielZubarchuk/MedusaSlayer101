package caveExplorer.VictorAndGabriel;

import java.util.Random;

public class GabrielMinesweeperBoard {

	public int[][] mineBoard;
    Random random = new Random();
    
    public GabrielMinesweeperBoard (){
       
    }
    
    public void createBoard(){
    	 mineBoard = new int[10][10];
         initiateBoard();
         randomlyPlaceMines();
         placeNumbers();
    }
   
    public void initiateBoard(){
    	//method first sets all cells of the board to 0
    	for(int i=0 ; i<mineBoard.length ; i++)
    		for(int j=0 ; j<mineBoard.length ; j++)
    			mineBoard[i][j]=0;
    }
    
    public void randomlyPlaceMines(){
    	//method places mines randomly on board.
    	//mines marked with -1
        boolean randomized;
        randomized = true;
        int row = 0;
        int col = 0;
        for(int i=0 ; i<10 ; i++){
            while(randomized){
                row = random.nextInt(8) + 1;
                col = random.nextInt(8) + 1;
                if(mineBoard[row][col] == -1){
                	randomized = true;
                }
                else{
                    randomized = false;
                }
            }
            mineBoard[row][col] = -1;
        }
    }
    
    public void placeNumbers(){
        for(int row=1 ; row < 9 ; row++){
            for(int col=1 ; col < 9 ; col++){
                for(int i=-1 ; i<=1 ; i++){
                	for(int j=-1 ; j<=1 ; j++){
                		if(mineBoard[row][col] != -1){
                			if(mineBoard[row+i][col+j] == -1){
                				mineBoard[row][col]++;
                            }
                        }
                    }
                }        
            }
        }    
    }
   
}

