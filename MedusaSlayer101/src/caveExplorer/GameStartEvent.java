package caveExplorer;

public class GameStartEvent implements Playable {

	private static final String[] SEQUENCE_1 = {"<A little yellow mouse with brown "
			+ "stripes and a lightening shaped tail runs up to you.>" + "Hi, I can see "
					+ "you are not from around here.", "Do you like puzzles?"};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing my 2-D games"
			+ ". Take this map."};
	
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
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
