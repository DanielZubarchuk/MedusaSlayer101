package caveExplorer.VictorAndGabriel;

public class VictorMinesweeperInterpreter{
	public VictorMinesweeperInterpreter() {
		
	}
	
	public static void interpretInput(int row, int col, int[][] board, boolean flag){
		if(flag == true){
			EventVictorAndGabriel.playerBoard[row][col] = -1 ; // x for supposed mine
			return;
		}
		if(EventVictorAndGabriel.firstTurn == true){
			EventVictorAndGabriel.playerBoard[row][col] = 0;	// first click is always blank
		//	GabrielMinesweeperBoard.createBoard(row, col);
			EventVictorAndGabriel.firstTurn = false;
		}
		checkNeighbors(row, col,board,row,col);
	}

	private static void checkNeighbors(int currRow, int currCol, int[][] board, int firstRow, int firstCol) {
		if(currRow == firstRow && currCol == firstCol){
			return;
		}
		if(currRow - 1 >= 0){
			if(board[currRow - 1][currCol] >= 0){
				currRow = currRow - 1;
			}
			if(currCol - 1 >= 0){
				if(board[currRow][currCol - 1] >= 0){
					
				}
			}
		}
		
		
	}

	public static boolean win(int[][] playerBoard, int[][] board) {
		for(int row = 0; row < playerBoard.length; row++){
			for(int col = 0; col < playerBoard[row].length; col++){
				if(playerBoard[row][col] != board[row][col]){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkMine(int rowChoice, int colChoice, int[][] board) {
		if(board[rowChoice][colChoice] == -1){
			return true;
		}
		return false;
	}
}

/** 
(0,board[row].length - 1)
row - 1 >= 0
col + 1 <= board[row].length 

(0,0)
row - 1 >= 0
col - 1 >= 0

(0, board.length - 1)
row + 1 <= board.length
col - 1 >= 0

(board.length - 1, board[row].length - 1)
row + 1 <= board.length
col + 1 <= board[row].length


-blank board
-user inputs cell
-save cell coordinate
-cell is always blank
-generate board around the blank cell
-continue
 */
