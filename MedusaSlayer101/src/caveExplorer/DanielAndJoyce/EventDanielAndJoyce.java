package caveExplorer.DanielAndJoyce;

import caveExplorer.*;

public class EventDanielAndJoyce implements Playable{

	private static final String[] SEQUENCE_1 = {"I am Sergeant Dan and I am forcing you to fight the Romans."};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing Battleship against the Romans."
			+ ". Welcome to the battlefield."};
	private static final String[] SEQUENCE_3 = {"You have defeated the Romans. Take this sword to face your greatest foe. "};
	public static boolean gameWork;
	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Please tell me you have played Battleship before.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Come on! You know you played Battleship. Say yes!");
		}
		readSequence(SEQUENCE_2);
		
//		JoyceBattleCreate.initializeField(JoyceBattleCreate.pField);
//		JoyceBattleCreate.makeField();
		gameWork = true;
		while(gameWork){
			// instantiate the fields
			DanielBattleCreate.field = new int[7][7];
			DanielBattleCreate.ships = new String[7][7];
			DanielBattleCreate.backField(DanielBattleCreate.field);
			DanielBattleCreate.makeField(DanielBattleCreate.field);
			JoyceBattleCreate.userField();
			DanielBattleCreate.createStarterCoordinates(DanielBattleCreate.ships);
			DanielBattleCreate.placeCarrier(DanielBattleCreate.ships, DanielBattleCreate.carrierRow, DanielBattleCreate.carrierCol);
			DanielBattleCreate.placeBattleship(DanielBattleCreate.ships, DanielBattleCreate.battleRow, DanielBattleCreate.battleCol);
			DanielBattleCreate.placeSubmarine(DanielBattleCreate.ships, DanielBattleCreate.subRow, DanielBattleCreate.subCol);
			DanielBattleCreate.placeCarrier(DanielBattleCreate.ships, DanielBattleCreate.destroyerRow, DanielBattleCreate.destroyerCol);
			DanielBattleCreate.fireCannon();
			JoyceBattleCreate.aiHitPlayer();
		}
		
		
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
