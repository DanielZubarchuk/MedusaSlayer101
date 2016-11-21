package caveExplorer;

public class GameStartEvent implements Playable {

	private static final String[] SEQUENCE_1 = {"<You see the silhouette of a person and it approaches you.>","Hi I'm Hermes, Messenger of the Gods.", 
			"I can't believe you were sent on this dangerous quest without any guidance.","Here. This is a map of the cave."};
	private static final String[] SEQUENCE_2 = {"Safe travels.","This is the most help I'm allowed you give you.","<Hermes hands you the map and vanishes.>"};
	
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Do you want it?");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("I insist. You'll be lost in here forever without it.");
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
