package caveExplorer.VictorAndGabriel;

import caveExplorer.Playable;
import caveExplorer.caveExplorer;

public class EventVictorAndGabriel implements Playable{

	private static final String[] SEQUENCE_1 = {"As you step into the room, a grid slowly extrudes from the wall and engravings lined across"
			+ "the stone begin to glow.","They read: This is a game called Minesweeper.", "The grid before you is laced with mines.", 
			"Mark all the mines with a flag. Uncover all the numbers to win.", "Hit a mine and this quest of yours is over.", "This room"
					+ "will explode upon doing so."};
	private static final String[] SEQUENCE_2 = {"Good Luck!", "Take this map too, even if you already have one."};
	
	public EventVictorAndGabriel() {

	}
	
	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Come on. Tell me you like puzzles.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Do you agree to the terms of this game?");
		}
		readSequence(SEQUENCE_2);
/*		if(caveExplorer.inventory.hasMap == false){
			
		}
		hasMap field in InventoryNockles has to be public for this condition to work
*/
		caveExplorer.inventory.setHasMap(true);
	}

	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}

}
