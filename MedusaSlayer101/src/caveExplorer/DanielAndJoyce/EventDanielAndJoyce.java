package caveExplorer.DanielAndJoyce;

import caveExplorer.*;

public class EventDanielAndJoyce implements Playable{

	private static final String[] SEQUENCE_0 = {"You have lost. The Romans find you pitiful and refuse to play you again.", 
		"They throw a sword down at your feet and spit on you."};
	private static final String[] SEQUENCE_1 = {"Welcome Perseus, I am Sergeant Dan and We are in great need of your assistance."};
	private static final String[] SEQUENCE_2 = {"Prove that you are worthy.Destroy the Roman Navy and finish your destiny."
			+ ". Welcome to the battlefield."};
	private static final String[] SEQUENCE_3 = {"You have defeated the Romans. Take this sword to face your greatest foe. "};
	private static final String[] SEQUENCE_4 = {"The Romans have aligned with Medusa to protect her from the heroes that are trying to kill her."};
	private static final String[] SEQUENCE_5 = {"The weapon that is required to defeat Medusa is locked away and can only be opened by someone worthy."};
	public static boolean gameWork;
	public void play () {
		readSequence(SEQUENCE_1);
		System.out.println("Please tell me you have played Battleship before.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Come on! You know you played Battleship. Say yes!");
		}
		readSequence(SEQUENCE_4);
		readSequence(SEQUENCE_5);
		readSequence(SEQUENCE_2);
		InventoryNockles.hasSword = false;
		// initialize fields
		DanielBattleCreate.engageInBattle();
		JoyceBattleCreate.userField(); 
		System.out.println("***If you ever feel like GIVING UP, type '-1'.***");
		
		gameWork = true;
		//if (DanielBattleCreate.cheatMode != true){
			while(gameWork){
				DanielBattleCreate.fireCannon();
				if(DanielBattleCreate.gameWin == true) break;
				JoyceBattleCreate.aiHitPlayer();
			//}
		}
		
		if(JoyceBattleCreate.aiWin == true){
			readSequence(SEQUENCE_0);
		}
		readSequence(SEQUENCE_3);
		InventoryNockles.hasSword = true;
	}

	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}
}
