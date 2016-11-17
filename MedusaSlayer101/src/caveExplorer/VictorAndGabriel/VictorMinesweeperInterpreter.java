package caveExplorer.VictorAndGabriel;

public class VictorMinesweeperInterpreter{

	public VictorMinesweeperInterpreter() {
		
	}
	
	public static void interpretInput(int row, int col, String[][] board){
		board[row][col] = "";	// first click is always blank
	//	GabrielMinesweeperBoard.createBoard(row, col);
		int startrow = -1;
		int startcol = -1;
		while(startrow != row && startcol != col){
			if(row - 1 >= 0 && col + 1 <= board[row].length && row + 1 <= board.length && col - 1 >= 0){
				if(board[row][col - 1] == ""){
					// change playerboard[row][col - 1] to ""
					col--;
				}else{
					if(board[row][col + 1] == ""){
						col++;
					}else{
						if(board[row - 1][col] == ""){
							row--;
						}else{
							if(board[row + 1][col] == ""){
								row++;
							}else{
								// end of turn and reveal the board 
								startrow = row;
								startcol = col;
							}
						}
					}
				}
			}	
		}
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
