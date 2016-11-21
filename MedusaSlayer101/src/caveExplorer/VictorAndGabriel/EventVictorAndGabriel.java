package caveExplorer.VictorAndGabriel;

import caveExplorer.InventoryNockles;
import caveExplorer.Playable;
import caveExplorer.caveExplorer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventVictorAndGabriel implements Playable{
	
	Scanner input = new Scanner(System.in);
	public static int[][] board;
	public static String[][] playerBoard;
	public static boolean firstTurn;
	private static final String[] SEQUENCE_1 = {"As you step into the room, a grid slowly extrudes from the wall and engravings lined across"
			+ " the stone begin to glow.","They read: This is a game called Minesweeper.", "The grid before you is laced with mines.", 
			"Mark all the mines with a flag. Uncover all the numbers to win.", "Hit a mine and this quest of yours is over.", "This room"
					+ " will explode upon doing so."};
	private static final String[] SEQUENCE_2 = {"Good Luck!"};
	private static final String[] SEQUENCE_3 = {"As you complete the puzzle, the words on the wall glow."
			,"You have completed this puzzle."
			,"As your reward, take this helmet. "};
	
	public EventVictorAndGabriel() {
		
	}
	
	public void play() {
		InventoryNockles.hasHelmet = false;
		int rowChoice = 0;
		int colChoice = 0;
		String flagToggle = "";
		firstTurn = true;
		playerBoard = new String[8][8];
		board = new int[8][8];
		
		for(int row = 0; row < playerBoard.length; row++){
			for(int col = 0; col < playerBoard[row].length; col++){
				playerBoard[row][col] = "?";
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
			
			input.nextLine(); // clears the nextline
			System.out.println("Would you like to flag?");
			flagToggle = input.nextLine();
			
			if(flagToggle.toLowerCase().equals("yes")){
				flag = true;
			}else{
				if(flagToggle.toLowerCase().equals("hochen")){
					break;
				}
			}
			input.nextLine();
			
//			try{
//				System.out.println("Please enter a row between 0 and 7.");
//				rowChoice = input.nextInt();
//				input.nextLine();
//			}catch(InputMismatchException exception){
//				System.out.println("This is not an integer");
//			}
			
			System.out.println("Please enter a row between 0 and 7.");
			rowChoice = input.nextInt();
			while(!validInput(rowChoice)){
				System.out.println("Please enter a row between 0 and 7.");
				rowChoice = input.nextInt();
				input.nextLine();
			}
			
			System.out.println("Please enter a col between 0 and 7.");
			colChoice = input.nextInt();
			while(!validInput(colChoice)){
				System.out.println("Please enter a col between 0 and 7.");
				colChoice = input.nextInt();
				input.nextLine();
			}
			
			if(VictorMinesweeperInterpreter.checkMine(rowChoice, colChoice, board) == true && flag == false){
				System.out.println("You hit a mine! Game Over! \n");
				printBoardInt(board); // show board when hitting mine
				return;
			}else{
				VictorMinesweeperInterpreter.interpretInput(rowChoice, colChoice, board, flag);
			}
		}
		printBoardInt(board);
		readSequence(SEQUENCE_3);
		InventoryNockles.hasHelmet = true; // receive helmet from winning
		
/*		if(caveExplorer.inventory.hasMap == false){
			readSequence(SEQUENCE_3);
			caveExplorer.inventory.setHasMap(true);
		}
*/		
	}

	private boolean validInput(int rowChoice) {
		if(rowChoice < 0 || rowChoice > 7){
			return false;
		}
		return true;
	}
	
	private void printBoardInt(int[][] board) { //post-game
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
	public static void printBoard(String[][] board){//in-game
		System.out.print("\n");
		System.out.print("Row         ");
		//System.out.print("\n");
		System.out.print("\n");
		for(int row = 0; row < board.length; row++){
			System.out.print(row+"   |" +" ");
			for(int col = 0; col < board[row].length; col++){
				System.out.print("  " + board[row][col]);
			}
			System.out.println("\n" + "    |");
		}
		System.out.print("     "+"-------------------------");
		System.out.print("\n");
		System.out.print("      ");
		for(int colNumb = 0; colNumb < board.length; colNumb++){
			System.out.print("  "+colNumb);
		}
		System.out.print("\n");
		System.out.print("               Column");
		System.out.print("\n");
		System.out.print("\n");
	}
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}

}
