package caveExplorer;
import java.util.Scanner;

public class MedusaBattle implements Playable {
	Scanner input = new Scanner(System.in);
	private static final String[] SEQUENCE_1 = {"<A sense of dread fills your body.>", "Great danger lies beyond this room."};
	private static final String[] SEQUENCE_2 = {"<The deadly gorgan, Medusa slithers towards you from the corner of the room.>", "<You quickly put on your helmet and you become invisible.>",
			"<You carefully walk around Medusa, careful not to look into her eyes.>","<You keep track of Medusa's reflection with your shield.>","<Medusa starts thrashing her tail randomly in hopes of hitting you.>","Luckily, your shield blocks you from her strike.",
			"<Finally, with a mighty swing of your sword, you cut Medusa's head off.>","Medusa is dead.","You are victorious!"};
	private static final String[] SEQUENCE_3 = {"<The deadly gorgan, Medusa slithers towards you from the corner of the room.>", "You have nothing to defend yourself with against such a monster.",
			"<Medusa makes eye contact with you and you feel your body stiffen up.>", "<Your body starts turning to stone.>", "You failed your quest and became another piece of Medusa's collection."};
	
	public MedusaBattle() {
		
	}

	public void play() {
		readSequence(SEQUENCE_1);
		if(InventoryNockles.hasHelmet && InventoryNockles.hasShield && InventoryNockles.hasSword){
			readSequence(SEQUENCE_2);
		}
		else{
			readSequence(SEQUENCE_3);
			System.out.println("Game Over");
		}
		System.exit(0);
	}

	public static void readSequence(String[] seq){
		for(String s : seq){
			System.out.println(s);
			System.out.println("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}
}
