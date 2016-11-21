package caveExplorer;

public class GameStartEvent implements Playable {

	private static final String[] SEQUENCE_1 = {"You see the silhouette of a person and it approaches you.","I was on my way out of the cave until I found this paper.", 
			"It seems to be a map of sorts."};
	private static final String[] SEQUENCE_2 = {"Safe travels friend.","The man hands you the map."};
	
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("I have no use for it. Do you want it?");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("I insist. I absolutely have no use for it.");
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
