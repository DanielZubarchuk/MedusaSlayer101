package caveExplorer.VictorAndGabriel;

import caveExplorer.Playable;
import caveExplorer.caveExplorer;

public class EventVictorAndGabriel implements Playable{
	
	public static boolean hasHelmet;
	public static String[][] board;
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
		readSequence(SEQUENCE_1);
		System.out.println("Win and you shall receive a helmet of invisibility. \n- - - press enter - - - ");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Do you agree to the terms of this game?");
		}
		readSequence(SEQUENCE_2);
		board = GabrielMinesweeperBoard.createBoard();
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
