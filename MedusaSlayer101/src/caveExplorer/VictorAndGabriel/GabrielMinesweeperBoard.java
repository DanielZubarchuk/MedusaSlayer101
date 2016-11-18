package caveExplorer.VictorAndGabriel;

import java.util.Random;

public class GabrielMinesweeperBoard {

	private int[][] mineBoard;
    private char[][] gameBoard;
    Random random = new Random();
    
    public GabrielMinesweeperBoard (){
        mineBoard = new int[10][10];
        gameBoard = new char[10][10];
        initiateBoard();
        randomlyPlaceMines();
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
        int row = 0, col = 0;
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
   
}

