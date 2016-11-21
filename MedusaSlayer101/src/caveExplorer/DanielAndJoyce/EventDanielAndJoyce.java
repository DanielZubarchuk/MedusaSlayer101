package caveExplorer.DanielAndJoyce;

import caveExplorer.*;

public class EventDanielAndJoyce implements Playable{

	private static final String[] SEQUENCE_1 = {""};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing Battleship against the Romans."
			+ ". Take this map."};

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Please tell me you have played Battleship before.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Come on! You know you played Battleship. Say yes!");
		}
		readSequence(SEQUENCE_2);
		//JoyceBattleCreate.userField();
		DanielBattleCreate.engageInBattle();
		/*while ()
		DanielBattleCreate.fireCannon();
		
		JoyceBattleCreate.aiHitPlayer();*/
	}

	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}
}
