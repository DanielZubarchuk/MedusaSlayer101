package caveExplorer.VictorAndGabriel;

import caveExplorer.Playable;
import caveExplorer.caveExplorer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventVictorAndGabriel implements Playable{
	
	Scanner input = new Scanner(System.in);
	public static boolean hasHelmet;
	public static int[][] board;
	public static String[][] playerBoard;
	public static boolean firstTurn;
	private static final String[] SEQUENCE_1 = {"As you step into the room, a grid slowly extrudes from the wall and engravings lined across"
			+ " the stone begin to glow.","They read: This is a game called Minesweeper.", "The grid before you is laced with mines.", 
			"Mark all the mines with a flag. Uncover all the numbers to win.", "Hit a mine and this quest of yours is over.", "This room"
					+ " will explode upon doing so."};
	private static final String[] SEQUENCE_2 = {"Good Luck!"};
	private static final String[] SEQUENCE_3 = {"As you complete the puzzle, the words on the wall glow."
			,"You "
			,"You have completed this puzzle."
			,"As your reward, ","Take this map with you too!"};
	
	public EventVictorAndGabriel() {
		
		
	}
	/** 
	 	FOR GABRIEL HOHOHOHOHOHO 
	 	
	 	FINISH THE TEXT AFTER WINNING 
	 	WE WILL LEAVE THE HELMET STUFF FOR TOMORROW WITH THE REST OF THE GROUP
	 	
		THE BACKEND BOARD SHOULD:
		-USE -1 FOR MINES
		-USE 0 FOR BLANKS
		
		THE FRONTEND BOARD:
		- IS A STRING[][]
		-USES X FOR SUPPOSED MINE
		- USE BLANK FOR THE HIDDEN CELLS
		- SHOULD HAVE THE ROW/COL NUMBERS AROUND THE BOARD
		- THESE LABELS ARE JUST PRINTS. NOT PART OF THE ARRAY
		
		SCROLL DOWN FOR PRINT BOARD METHOD
		I INSTANTIATED BOARD AND PLAYER BOARD IN THE PLAY() METHOD
		BOARD[0][0] = 1 FOR NOW BECAUSE WE HAVE NOT MADE THE BACKEND BOARD YET
		
		RUN YOUR CODE AT:
		MY CLASS AT GabrielMinesweeperBoard.createBoard(row, col); IN MY CODE
		YOUR CREATEBOARD METHOD WILL CREATE THE REST OF THE BOARD BASED ON THE FIRST INPUT OF THE USER
		ROW AND COL PARAMETERS ARE JUST INT
		
		WHEN YOU HAVE MADE THE CREATEBOARD METHOD, LET ME KNOW. 
		I WILL UNCOMMENT MY FUNCTION CALL : GabrielMinesweeperBoard.createBoard(row, col);
		BECAUSE RIGHT NOW THERE WOULD BE AN ERROR SINCE YOU HAVEN'T CREATED IT YET
	
	**/
	public void play() {
		int rowChoice = 0;
		int colChoice = 0;
		String flagToggle = "";
		firstTurn = true;
		
		// 2x2 array for testing purposes
		// change back to 8x8 or allow user to choose size of board
		// this board itself breaks the rules of minesweeper since they technically cant be a blank
		// the board itself is too small
		// just for testing purposes though
		playerBoard = new String[2][2];
		board = new int[2][2];
		board[0][0] = -1;
		board[0][1] = 1;
		board[1][0] = 1;
		board[1][1] = 1;
		
		// playerboard starts as blank
		for(int row = 0; row < playerBoard.length; row++){
			for(int col = 0; col < playerBoard[row].length; col++){
				playerBoard[row][col] = " ";
			}
		}
		
		
		readSequence(SEQUENCE_1);
		System.out.println("Win and you shall receive a helmet of invisibility. \n- - - press enter - - - ");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Do you agree to the terms of this game?");
		}
		readSequence(SEQUENCE_2);
	
		while(!VictorMinesweeperInterpreter.win(playerBoard,board)){
			printBoard(playerBoard);
			boolean flag = false;
			
			System.out.println("Would you like to flag?");
			flagToggle = input.nextLine();
			
			if(flagToggle.toLowerCase().equals("yes")){
				flag = true;
			}
			
			try{
				System.out.println("Please enter a row between 0 and 7.");
				rowChoice = input.nextInt();
				input.nextLine();
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
			}
			
			try{
				System.out.println("Please enter a col between 0 and 7.");
				colChoice = input.nextInt();
				input.nextLine();
			}catch(InputMismatchException exception){
				System.out.println("This is not an integer");
			}
			
			if(VictorMinesweeperInterpreter.checkMine(rowChoice, colChoice, board) == true && flag == false){
				System.out.println("You hit a mine! Game Over! \n");
				return;
			}else{
				VictorMinesweeperInterpreter.interpretInput(rowChoice, colChoice, board, flag);
			}
		}
		printBoardInt(board);
		readSequence(SEQUENCE_3);
/*		if(caveExplorer.inventory.hasMap == false){
			readSequence(SEQUENCE_3);
			caveExplorer.inventory.setHasMap(true);
		}
*/		
	}

	private void printBoardInt(int[][] board) {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				if(board[row][col] == -1){
					System.out.print("  " + "X");
				}else{
					System.out.print("  " + board[row][col]);
				}
			}
			System.out.println("\n");
		}
		
	}
	public static void printBoard(String[][] board){
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				System.out.print("  " + board[row][col]);
			}
			System.out.println("\n");
		}
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}

}
