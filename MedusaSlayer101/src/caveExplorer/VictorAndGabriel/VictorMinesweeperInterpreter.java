package caveExplorer.VictorAndGabriel;

public class VictorMinesweeperInterpreter{
	public VictorMinesweeperInterpreter() {
		
	}
	
	public static void interpretInput(int row, int col, int[][] board, boolean flag){
		if(flag == true){
			if(EventVictorAndGabriel.playerBoard[row][col].equals("X")){
				EventVictorAndGabriel.playerBoard[row][col] = " ";
			}else{
				EventVictorAndGabriel.playerBoard[row][col] = "X" ; // X for supposed mine
			}
			return;
		}
		if(EventVictorAndGabriel.firstTurn == true){
			EventVictorAndGabriel.playerBoard[row][col] = 0 + "";	// first click is always blank
		//	GabrielMinesweeperBoard.createBoard(row, col);
			EventVictorAndGabriel.firstTurn = false;
		}
		checkNeighbors(row, col,board);
	}

	private static void checkNeighbors(int row, int col, int[][] board) {
		if(row >= 0 && row <= board.length && col >= 0 && col <= board[row].length && board[row][col] >= 0){
			EventVictorAndGabriel.playerBoard[row][col] = board[row][col] + "";
			checkNeighbors(row + 1, col, board);
			checkNeighbors(row - 1, col, board);
			checkNeighbors(row, col + 1, board);
			checkNeighbors(row, col - 1, board);
		}else{
			return;
		}
	}

	public static boolean win(String[][] playerBoard, int[][] board) {
		for(int row = 0; row < playerBoard.length; row++){
			for(int col = 0; col < playerBoard[row].length; col++){
				if(playerBoard[row][col].equals(board[row][col] + "")){
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
