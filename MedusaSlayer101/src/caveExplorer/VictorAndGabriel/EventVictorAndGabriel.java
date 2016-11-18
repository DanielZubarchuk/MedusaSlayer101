package caveExplorer.VictorAndGabriel;

import caveExplorer.Playable;
import caveExplorer.caveExplorer;
import java.util.Scanner;

public class EventVictorAndGabriel implements Playable{
	
	Scanner input = new Scanner(System.in);
	public static boolean hasHelmet;
	public static String[][] board;
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
	
	public void play() {
		int rowChoice = 0;
		int colChoice = 0;
		firstTurn = true;
		playerBoard = new String[8][8];
		
		readSequence(SEQUENCE_1);
		System.out.println("Win and you shall receive a helmet of invisibility. \n- - - press enter - - - ");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Do you agree to the terms of this game?");
		}
		readSequence(SEQUENCE_2);
		
		for(int row = 0; row < playerBoard.length; row++){
			for(int col = 0; col < playerBoard[row].length; col++){
				System.out.print("  " + playerBoard[row][col]);
			}
			System.out.println("\n");
		}
		
		while(VictorMinesweeperInterpreter.win(playerBoard,board) == false){
			System.out.println("Please enter a row.");
			rowChoice = input.nextInt();
			System.out.println("Please enter a col.");
			colChoice = input.nextInt();
			
			VictorMinesweeperInterpreter.interpretInput(rowChoice, colChoice, board);
		}
/*		if(caveExplorer.inventory.hasMap == false){
			readSequence(SEQUENCE_3);
			caveExplorer.inventory.setHasMap(true);
		}
*/		
	}

	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}

}
