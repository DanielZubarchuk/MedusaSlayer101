package caveExplorer;

public class MedusaBattle implements Playable {

	public MedusaBattle() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		if(InventoryNockles.hasHelmet && InventoryNockles.hasShield && InventoryNockles.hasSword){
			System.out.println("With the power of the three god items, you slay the gorgon sister, Medusa.");
			System.out.println("Your journey is over.");
		}else{
			System.out.println("You battle Medusa to no avail. You should have collected all the god items first.");
			System.out.println("Game over!");
		}
		System.exit(0);
	}

}
