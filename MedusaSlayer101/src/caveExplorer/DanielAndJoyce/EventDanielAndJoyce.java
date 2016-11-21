package caveExplorer.DanielAndJoyce;

import caveExplorer.*;

public class EventDanielAndJoyce implements Playable{

	private static final String[] SEQUENCE_1 = {"I am Sergeant Dan and I am forcing you to fight the Romans."};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing Battleship against the Romans."
			+ ". Welcome to the battlefield."};
	private static final String[] SEQUENCE_3 = {"You have defeated the Romans. Take this sword to face your greatest foe. "};

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Please tell me you have played Battleship before.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Come on! You know you played Battleship. Say yes!");
		}
		readSequence(SEQUENCE_2);
		
		JoyceBattleCreate.initializeField(JoyceBattleCreate.pField);
		JoyceBattleCreate.makeField();
		DanielBattleCreate.backField(DanielBattleCreate.field);
		DanielBattleCreate.makeField(DanielBattleCreate.field);
		JoyceBattleCreate.userField();
		DanielBattleCreate.createStarterCoordinates(DanielBattleCreate.ships);
		
		
		
		
		//JoyceBattleCreate.userField();
		//DanielBattleCreate.engageInBattle();
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
