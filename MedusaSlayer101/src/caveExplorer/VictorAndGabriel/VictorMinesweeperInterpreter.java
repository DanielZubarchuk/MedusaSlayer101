package caveExplorer.VictorAndGabriel;

public class VictorMinesweeperInterpreter{

	public VictorMinesweeperInterpreter() {
		
	}
	
	public static void initiateGame(int row, int col, String[][] board){
		board[row][col] = "";
	//	GabrielMinesweeperBoard.createBoard(row, col);
	}

	public static boolean win() {
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