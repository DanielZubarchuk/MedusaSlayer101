package caveExplorer.DanielAndJoyce;

import caveExplorer.*;

public class EventDanielAndJoyce implements Playable{

	private static final String[] SEQUENCE_1 = {""};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing Battleship against the Romans."
			+ ". Take this map."};

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Come on. Tell me you like puzzles.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Come on! You know you like puzzles. Say yes!");
		}
		readSequence(SEQUENCE_2);
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
