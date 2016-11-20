package caveExplorer.VictorAndGabriel;

public class VictorMinesweeperInterpreter{
	public static boolean[][] alreadyChecked;
	
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
			EventVictorAndGabriel.board[row][col] = 0;	// first click is always 0/blank
		//	GabrielMinesweeperBoard.createBoard(row, col);
			EventVictorAndGabriel.firstTurn = false;
		}
		alreadyChecked = new boolean[8][8];
		checkNeighbors(row, col,board);
	}

	public static void checkNeighbors(int row, int col, int[][] board) {
		if(row >= 0 && row <= board.length - 1 && col >= 0 && col <= board[row].length - 1 && alreadyChecked[row][col] == false){
			alreadyChecked[row][col] = true;
			if(board[row][col] == 0){
				EventVictorAndGabriel.playerBoard[row][col] = board[row][col] + "";
				checkNeighbors(row + 1, col, board);
				checkNeighbors(row - 1, col, board);
				checkNeighbors(row, col + 1, board);
				checkNeighbors(row, col - 1, board);
				return;
			}else{
				EventVictorAndGabriel.playerBoard[row][col] = board[row][col] + "";
			}
		}else{
			return;
		}
	}

	public static boolean win(String[][] playerBoard, int[][] board) {
		for(int row = 0; row < playerBoard.length; row++){
			for(int col = 0; col < playerBoard[row].length; col++){
				String intString = Integer.toString(board[row][col]);
				if(board[row][col] == -1){
					if(!playerBoard[row][col].equals("X")){
						return false;
					}
				}else{
					if(!playerBoard[row][col].equals(intString)){
						return false;
					}
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
